package br.com.baseapplication.data.source.local

import br.com.baseapplication.entity.Pokemon
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    fun pokemonListFlow(): Flow<List<Pokemon>>
    suspend fun savePokemonList(pokemonList: List<Pokemon>?)
}