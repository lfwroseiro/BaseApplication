package br.com.baseapplication.domain.di

import br.com.baseapplication.domain.usecase.ExampleUseCase
import br.com.baseapplication.domain.usecase.ExampleUseCaseImpl
import org.koin.dsl.module

object DomainModules {

    private val useCaseModule = module {
        single<ExampleUseCase> { ExampleUseCaseImpl(get()) }
    }

    val domainModules = listOf(useCaseModule)
}
