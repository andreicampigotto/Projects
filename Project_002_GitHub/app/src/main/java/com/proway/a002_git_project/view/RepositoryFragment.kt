package com.proway.a002_git_project.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proway.a002_git_project.R
import com.proway.a002_git_project.adapter.RepositoriesAdapter
import com.proway.a002_git_project.databinding.RepositoryFragmentBinding
import com.proway.a002_git_project.view_model.RepositoryViewModel

class RepositoryFragment : Fragment(R.layout.repository_fragment) {

    companion object {
        fun newInstance() = RepositoryFragment()
    }

    private lateinit var viewModel: RepositoryViewModel
    private lateinit var binding: RepositoryFragmentBinding
    private val adapter = RepositoriesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= RepositoryFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(RepositoryFragment::class.java)
    }

}