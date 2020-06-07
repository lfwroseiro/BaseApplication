package br.com.baseapplication.data.source.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import br.com.baseapplication.data.source.local.db.entity.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao : BaseDao<PokemonEntity> {

    @Query("SELECT * from pokemon")
    fun pokemonList(): Flow<List<PokemonEntity>>
}
