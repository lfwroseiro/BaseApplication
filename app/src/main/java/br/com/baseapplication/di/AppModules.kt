package br.com.baseapplication.di

import br.com.baseapplication.ui.example.ExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModules {

    private val viewModelModules = module {
        viewModel { ExampleViewModel(get()) }
    }

    val appModules = listOf(viewModelModules)
}
