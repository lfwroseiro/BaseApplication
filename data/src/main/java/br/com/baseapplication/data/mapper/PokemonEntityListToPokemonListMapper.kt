package br.com.baseapplication.data.mapper

import br.com.baseapplication.data.source.local.db.entity.PokemonEntity
import br.com.baseapplication.entity.Pokemon

class PokemonEntityListToPokemonListMapper : Mapper<List<PokemonEntity>, List<Pokemon>> {

    override fun transform(item: List<PokemonEntity>) = item.map {
        Pokemon(
            name = it.name,
            url = it.url
        )
    }
}
