package br.com.baseapplication.ui.example

import br.com.baseapplication.R
import br.com.baseapplication.ui.base.BaseAdapter
import br.com.baseapplication.databinding.ItemPokemonBinding
import br.com.baseapplication.entity.Pokemon
import br.com.baseapplication.utils.extensions.cast

class PokemonListAdapter : BaseAdapter<Pokemon>(R.layout.item_pokemon, { pokemon, binding ->
    with(binding.cast<ItemPokemonBinding>()) {
        // Setting data class to <data> in item layout
        // If needed, set a viewModel variable in <data> to handle unit logic inside this item view
        this.pokemon = pokemon
    }
})