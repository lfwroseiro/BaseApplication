package br.com.baseapplication.data.api

import br.com.baseapplication.entity.PokemonSummary
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("pokemon")
    fun pokemonListAsync(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Deferred<Response<PokemonSummary>>
}
