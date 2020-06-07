package br.com.baseapplication.data.source

import br.com.baseapplication.data.mapper.Mapper
import br.com.baseapplication.data.source.local.UserLocalDataSource
import br.com.baseapplication.data.source.local.db.dao.PokemonDao
import br.com.baseapplication.data.source.local.db.entity.PokemonEntity
import br.com.baseapplication.entity.Pokemon
import kotlinx.coroutines.flow.map

class UserLocalDataSourceImpl(
    private val pokemonDao: PokemonDao,
    private val pokemonInMapper: Mapper<List<Pokemon>, List<PokemonEntity>>,
    private val pokemonOutMapper: Mapper<List<PokemonEntity>, List<Pokemon>>
) : UserLocalDataSource {

    // TODO: add cache strategy to clear db

    override fun pokemonListFlow() = pokemonDao.pokemonList().map {
        pokemonOutMapper.transform(it)
    }

    override suspend fun savePokemonList(pokemonList: List<Pokemon>?) {
        pokemonList?.let { pokemonDao.insert(pokemonInMapper.transform(it)) }
    }
}
