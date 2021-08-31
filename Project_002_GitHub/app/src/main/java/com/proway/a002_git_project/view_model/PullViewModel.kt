package com.proway.a002_git_project.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.a002_git_project.model.Pull
import com.proway.a002_git_project.repository.GitPullsRepository

class PullViewModel: ViewModel() {

    private val _pulls = MutableLiveData<List<Pull>>()
    val pulls: LiveData<List<Pull>> = _pulls

    val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val gitPull = GitPullsRepository()

    fun getPullsList() {
        gitPull.getPulls(fullName = ""){ list, error ->
            list?.apply {
               // _pulls.value = this
            }

            error?.apply {
                _error.value = this
            }
        }
    }
}