package com.proway.a002_git_project.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.proway.a002_git_project.R
import com.proway.a002_git_project.adapter.PullsAdapter
import com.proway.a002_git_project.databinding.PullsFragmentBinding
import com.proway.a002_git_project.model.Pull
import com.proway.a002_git_project.model.Repository
import com.proway.a002_git_project.view_model.PullViewModel
import com.proway.a002_git_project.view_model.RepositoryViewModel
import java.util.*

class PullFragment: Fragment(R.layout.pulls_fragment) {

    companion object {
        fun newInstance() = PullFragment()
    }

    private lateinit var viewModel: PullViewModel
    private lateinit var binding: PullsFragmentBinding
    private var adapter = PullsAdapter()

//    private val observerPull = Observer<List<Pull>> {
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = PullsFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(PullViewModel::class.java)

        binding.pullRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.pullRecyclerView.adapter = adapter

        //viewModel.pulls.observe(viewLifecycleOwner, observerPull)

        viewModel.getPullsList()
    }
}