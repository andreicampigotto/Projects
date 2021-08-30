package com.proway.a002_git_project.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.a002_git_project.databinding.ItemPullBinding
import com.proway.a002_git_project.model.Pull

class PullsAdapter: RecyclerView.Adapter<PullViewHolder>() {
    var pulls = mutableListOf<Pull>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PullViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}
class PullViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val binding: ItemPullBinding = ItemPullBinding.bind(itemView)

    fun bind(pull:Pull){

    }
}