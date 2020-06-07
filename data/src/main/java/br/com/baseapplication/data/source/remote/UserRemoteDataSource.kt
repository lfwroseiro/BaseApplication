package br.com.baseapplication.data.source.remote

import br.com.baseapplication.entity.PokemonSummary
import br.com.baseapplication.entity.Response
import br.com.baseapplication.entity.Values.TWENTY_VALUE
import br.com.baseapplication.entity.Values.ZERO_VALUE

interface UserRemoteDataSource {

    suspend fun pokemonList(
        offset: Int = ZERO_VALUE,
        limit: Int = TWENTY_VALUE
    ): Response<PokemonSummary>
}
