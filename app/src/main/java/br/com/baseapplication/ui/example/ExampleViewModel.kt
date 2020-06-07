package br.com.baseapplication.ui.example

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.asLiveData
import br.com.baseapplication.ui.base.BaseViewModel
import br.com.baseapplication.data.utils.RequestException
import br.com.baseapplication.domain.usecase.ExampleUseCase
import br.com.baseapplication.entity.Response

class ExampleViewModel(
    private val exampleUseCase: ExampleUseCase
) : BaseViewModel() {

    val pokemonList = exampleUseCase.pokemonListFlow().asLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        launch(::errorHandler, baseLoading) {
            exampleUseCase.fetchPokemonList()
        }
    }

    private fun errorHandler(e: RequestException) {
        when (e.error) {
            is Response.Error.Unauthorized -> {
                // Handle session expired
            }
            else -> {
                // Handle generic error
            }
        }
    }
}
