package br.com.baseapplication.domain.usecase

import br.com.baseapplication.domain.repository.UserRepository

class ExampleUseCaseImpl(
    private val userRepository: UserRepository
) : ExampleUseCase {

    override fun pokemonListFlow() = userRepository.pokemonListFlow()

    override suspend fun fetchPokemonList() {
        userRepository.fetchPokemonList()
    }
}
