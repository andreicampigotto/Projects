package com.proway.a002_git_project.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.a002_git_project.R
import com.proway.a002_git_project.databinding.ItemPullBinding
import com.proway.a002_git_project.model.Pull

class PullsAdapter: RecyclerView.Adapter<PullViewHolder>() {
    var pulls = mutableListOf<Pull>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_pull, parent, false).apply{
            return PullViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: PullViewHolder, position: Int) {
        pulls[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = pulls.size

    fun update(newlist: List<Pull>) {
        pulls.clear()
        pulls.addAll(newlist)
        notifyDataSetChanged()
    }
}
class PullViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val binding: ItemPullBinding = ItemPullBinding.bind(itemView)

    fun bind(pull:Pull){
        binding.tvPullTitle.text = pull.title
        binding.tvPullDescription.text = pull.body
    }
}