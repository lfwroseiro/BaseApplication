package br.com.baseapplication.domain.repository

import br.com.baseapplication.entity.Pokemon
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun pokemonListFlow(): Flow<List<Pokemon>>
    suspend fun fetchPokemonList()
}
