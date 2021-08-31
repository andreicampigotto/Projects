package com.proway.a002_git_project.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.a002_git_project.R
import com.proway.a002_git_project.databinding.ItemRepositoryBinding
import com.proway.a002_git_project.model.Repository

class RepositoriesAdapter : RecyclerView.Adapter<RepositoryViewHolder>() {

    private var repostories = mutableListOf<Repository>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false).apply {
            return RepositoryViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        repostories[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = repostories.size

    fun update(newlist: List<Repository>) {
        repostories.clear()
        repostories.addAll(newlist)
        notifyDataSetChanged()
    }
}

class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemRepositoryBinding = ItemRepositoryBinding.bind(itemView)

    fun bind(repository: Repository) {
        binding.tvRepositoryTitle.text = repository.name
        binding.tvRepositoryDescription.text = repository.description
        binding.textViewForkRepository.text = repository.forks_count.toString()
        binding.textViewStarsRepository.text = repository.stargazers_count.toString()
        binding.textViewViewsRepositoryWatchers.text = repository.watchers_count.toString()
        binding.textViewUsernameRepository.text = repository.owner.login
        binding.textViewNameLastnameRepository.text = repository.owner.html_url

        repository.owner.let {
            Glide.with(itemView.context).load(it.avatar_url)
                .into(binding.imageView)
        }
    }
}