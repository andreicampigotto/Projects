package com.proway.a002_git_project.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.proway.a002_git_project.databinding.ItemRepositoryBinding
import com.proway.a002_git_project.model.Repository

class RepositoriesAdapter {

}
class RepositoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private var binding: ItemRepositoryBinding = ItemRepositoryBinding.bind(itemView)

    fun bind(repository: Repository) {
        repository.let{
            binding.tvRepositoryTitle = it.name
            binding.tvRepositoryDescription = it.description
            binding.textViewForkRepository = it.forks_count
            binding.textViewStarsRepository = it.stargazers_count
            binding.textViewViewsRepositoryWatchers = it.watchers_count
            binding.
        }
    }
}