package com.proway.project_four.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.proway.project_four.adapter.PokemonAdapter
import com.proway.project_four.databinding.MainFragmentBinding
import com.proway.project_four.model.Pokemon
import com.proway.project_four.model.Pokemons
import com.proway.project_four.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    //latinit porque ele sera iniciado depois
    lateinit var pokeAdapter: PokemonAdapter

    //observa e notifica o viewmodel
    private val observerPokes = Observer<List<Pokemon>>{
        it
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        //instancia do viewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //implementacao da observacao do VM
        viewModel.pokemons.observe(viewLifecycleOwner, observerPokes)
    }

}