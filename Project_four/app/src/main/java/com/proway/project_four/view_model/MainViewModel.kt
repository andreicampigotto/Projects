package com.proway.project_four.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proway.project_four.model.Pokemon
import com.proway.project_four.repository.PokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PokeRepository
    ) : ViewModel() {

    //por que mesmo?
    private val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>> = _pokemons

    val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    //funcao para carregar todos os pokemons
    fun fetchPokemons() {
        viewModelScope.launch {

            //chamada dos pokemons vindo do service
            val returnedPokes = repository.fetchPokemons()

            //resposta do service para apresentar
            returnedPokes?.let {
                _pokemons.value = it.results
            }
        }
    }
}