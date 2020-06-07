package br.com.baseapplication.data.source.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.baseapplication.entity.Values.ZERO_VALUE

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = ZERO_VALUE,
    val name: String?,
    val url: String?
)