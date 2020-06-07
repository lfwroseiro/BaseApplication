package br.com.baseapplication.data.di

import androidx.room.Room
import br.com.baseapplication.data.api.UserService
import br.com.baseapplication.data.api.config.ApiClient.makeService
import br.com.baseapplication.data.mapper.PokemonEntityListToPokemonListMapper
import br.com.baseapplication.data.mapper.PokemonListToPokemonEntityListMapper
import br.com.baseapplication.data.repository.UserRepositoryImpl
import br.com.baseapplication.data.source.UserLocalDataSourceImpl
import br.com.baseapplication.data.source.local.UserLocalDataSource
import br.com.baseapplication.data.source.local.db.AppRoomDatabase
import br.com.baseapplication.data.source.remote.UserRemoteDataSource
import br.com.baseapplication.data.source.remote.UserRemoteDataSourceImpl
import br.com.baseapplication.domain.repository.UserRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataModules {

    private const val pokemonListToPokemonEntityListMapper = "PokemonListToPokemonEntityListMapper"
    private const val pokemonEntityListToPokemonListMapper = "PokemonEntityListToPokemonListMapper"

    private val dataUtilsModule = module {
        single<Moshi> { Moshi.Builder().add(KotlinJsonAdapterFactory()).build() }
    }

    private val serviceModule = module {
        // Remote
        single { makeService<UserService>(get(), get()) }

        // DB
        single {
            Room.databaseBuilder(
                get(),
                AppRoomDatabase::class.java,
                AppRoomDatabase.DB_NAME
            ).build()
        }
        single { get<AppRoomDatabase>().pokemonDao() }
    }

    private val sourcesModule = module {
        single<UserRemoteDataSource> { UserRemoteDataSourceImpl(get()) }
        single<UserLocalDataSource> {
            UserLocalDataSourceImpl(
                get(),
                get(named(pokemonListToPokemonEntityListMapper)),
                get(named(pokemonEntityListToPokemonListMapper))
            )
        }
    }

    private val repositoryModule = module {
        single<UserRepository> { UserRepositoryImpl(get(), get()) }
    }

    private val mapperModule = module {
        single(named(pokemonListToPokemonEntityListMapper)) {
            PokemonListToPokemonEntityListMapper()
        }

        single(named(pokemonEntityListToPokemonListMapper)) {
            PokemonEntityListToPokemonListMapper()
        }
    }

    val dataModules = listOf(
        dataUtilsModule,
        serviceModule,
        sourcesModule,
        repositoryModule,
        mapperModule
    )
}
