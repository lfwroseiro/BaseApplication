package br.com.baseapplication.ui.example

import androidx.databinding.DataBindingUtil
import br.com.baseapplication.R
import br.com.baseapplication.ui.base.BaseActivity
import br.com.baseapplication.databinding.ActivityExampleBinding
import br.com.baseapplication.utils.extensions.bind
import br.com.baseapplication.utils.extensions.setIsVisible
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExampleActivity : BaseActivity() {

    override val viewModel: ExampleViewModel by viewModel()

    private lateinit var binding: ActivityExampleBinding
    private lateinit var pokemonListAdapter: PokemonListAdapter

    override fun onCreate() {
        // Overriding BaseActivity onCreate() to inflate layout and set binding variable
        binding = DataBindingUtil.setContentView(this, R.layout.activity_example)
    }

    override fun setupScreen() {
        // Initial setup for this activity views
        pokemonListAdapter = PokemonListAdapter().also { binding.rvList.adapter = it }
    }

    override fun subscribeUi() {
        // Binding LiveData values from ViewModel to activity views
        bind(viewModel.pokemonList, pokemonListAdapter::setList)
        bind(viewModel.loading, binding.clpbLoading::setIsVisible)
    }

    // TODO: setup endless scroll, create a custom recycler view
    // TODO: check utilities to add
}
