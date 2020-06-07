package br.com.baseapplication.data.mapper

import br.com.baseapplication.data.source.local.db.entity.PokemonEntity
import br.com.baseapplication.entity.Pokemon

class PokemonListToPokemonEntityListMapper : Mapper<List<Pokemon>, List<PokemonEntity>> {

    override fun transform(item: List<Pokemon>) = item.map {
        PokemonEntity(
            name = it.name,
            url = it.url
        )
    }
}
