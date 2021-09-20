package com.proway.project_four.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.proway.project_four.R
import com.proway.project_four.databinding.ItemPokemonBinding
import com.proway.project_four.model.Pokemon

class PokemonAdapter : ListAdapter<Pokemon, PokemonViewHolder>(PokemonsDiffCallback()) {

    var listOf = mutableListOf<Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false).apply {
            return PokemonViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position).let { pokemon -> holder.bind(pokemon) }
    }
}

class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var binding: ItemPokemonBinding = ItemPokemonBinding.bind(itemView)

    fun bind(pokemon: Pokemon) {
        binding.textViewPokemonName.text = pokemon.name
    }
}