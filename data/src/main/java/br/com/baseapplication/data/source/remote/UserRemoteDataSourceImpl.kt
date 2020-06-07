package br.com.baseapplication.data.source.remote

import br.com.baseapplication.data.api.UserService
import br.com.baseapplication.data.utils.extensions.convert

class UserRemoteDataSourceImpl(
    private val userService: UserService
) : UserRemoteDataSource {

    override suspend fun pokemonList(offset: Int, limit: Int) =
        userService.pokemonListAsync(offset, limit).convert()
}
