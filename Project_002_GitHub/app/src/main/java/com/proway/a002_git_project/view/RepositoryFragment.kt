package com.proway.a002_git_project.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.proway.a002_git_project.R
import com.proway.a002_git_project.adapter.RepositoriesAdapter
import com.proway.a002_git_project.databinding.RepositoryFragmentBinding
import com.proway.a002_git_project.model.Repository
import com.proway.a002_git_project.view_model.RepositoryViewModel

class RepositoryFragment : Fragment(R.layout.repository_fragment) {

    companion object {
        fun newInstance() = RepositoryFragment()
    }

    private lateinit var viewModel: RepositoryViewModel
    private lateinit var binding: RepositoryFragmentBinding
    private val adapter = RepositoriesAdapter()

    private val observerRepository = Observer<List<Repository>> { repository ->
        adapter.update(repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= RepositoryFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(RepositoryViewModel::class.java)

        binding.repositoryRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.repositoryRecyclerView.adapter = adapter

        viewModel.repositories.observe(viewLifecycleOwner, observerRepository)

        viewModel.getRepositoriesList()
    }
}