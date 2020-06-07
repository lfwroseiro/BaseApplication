package br.com.baseapplication.data.repository

import br.com.baseapplication.data.source.local.UserLocalDataSource
import br.com.baseapplication.data.source.remote.UserRemoteDataSource
import br.com.baseapplication.data.utils.RequestException
import br.com.baseapplication.domain.repository.UserRepository
import br.com.baseapplication.entity.Response
import br.com.baseapplication.entity.Values.TWENTY_VALUE
import br.com.baseapplication.entity.Values.ZERO_VALUE

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {

    private var pokemonListOffset = ZERO_VALUE

    override fun pokemonListFlow() = userLocalDataSource.pokemonListFlow()

    override suspend fun fetchPokemonList() {
        when (val response = userRemoteDataSource.pokemonList(pokemonListOffset)) {
            is Response.Empty -> return
            is Response.Success -> {
                response.body.next?.let { pokemonListOffset += TWENTY_VALUE }
                userLocalDataSource.savePokemonList(response.body.pokemonList)
            }
            is Response.Error -> throw RequestException(response)
        }
    }
}
