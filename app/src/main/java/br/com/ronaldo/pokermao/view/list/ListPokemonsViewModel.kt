package br.com.ronaldo.pokermao.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ronaldo.pokermao.model.Pokemon
import br.com.ronaldo.pokermao.repository.PokemonRepository

class ListPokemonsViewModel (val pokemonRepository: PokemonRepository) : ViewModel() {
    val messageError: MutableLiveData<String> = MutableLiveData()
    val pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    fun getPokemons() {
        isLoading.value = true
        pokemonRepository.getPokemons(
            150, "number,asc", {
                pokemons.value = it
                messageError.value = ""
                isLoading.value = false
            }, {
                pokemons.value = emptyList()
                messageError.value = it?.message
                isLoading.value = false
            }
        )
    }
}