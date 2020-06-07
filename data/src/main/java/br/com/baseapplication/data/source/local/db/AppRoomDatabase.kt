package br.com.baseapplication.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.baseapplication.data.source.local.db.conveters.Converters
import br.com.baseapplication.data.source.local.db.dao.PokemonDao
import br.com.baseapplication.data.source.local.db.entity.PokemonEntity

@Database(
    entities = [PokemonEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    companion object {
        const val DB_NAME = "base-application-db"
    }
}