package com.proway.a002_git_project.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.a002_git_project.model.Repository
import com.proway.a002_git_project.repository.GitRepository

class RepositoryViewModel : ViewModel() {

    private val _repositories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>> = _repositories

    val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error

    private val gitRepository= GitRepository()

    fun getRepositoriesList() {
        gitRepository.getRepositoriesList(language = "Java", sort = "star", page = 1) { list, error ->
            list?.apply {
                _repositories.value = this
            }

            error?.apply {
                _error.value = this
            }
        }
    }
}