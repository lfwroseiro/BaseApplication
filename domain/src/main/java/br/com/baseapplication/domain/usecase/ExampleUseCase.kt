package br.com.baseapplication.domain.usecase

import br.com.baseapplication.entity.Pokemon
import kotlinx.coroutines.flow.Flow

interface ExampleUseCase {
    fun pokemonListFlow(): Flow<List<Pokemon>>
    suspend fun fetchPokemonList()
}
