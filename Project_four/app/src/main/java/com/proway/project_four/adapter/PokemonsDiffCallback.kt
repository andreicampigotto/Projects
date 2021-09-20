package com.proway.project_four.adapter

import androidx.recyclerview.widget.DiffUtil
import com.proway.project_four.model.Pokemon

class PokemonsDiffCallback: DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.name == newItem.name
    }
}