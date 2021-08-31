package com.proway.a002_git_project.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.a002_git_project.model.Repository
import com.proway.a002_git_project.repository.GitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RepositoryViewModel @Inject constructor(
    private val gitRepository: GitRepository
): ViewModel() {

    private val _repositories = MutableLiveData<List<Repository>>()
    val repositories: LiveData<List<Repository>> = _repositories

    val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error

    fun getRepositoriesList() {
        gitRepository.getRepositoriesList(language = "Kotlin", sort = "star", page = 1) { list, error ->
            list?.apply {
                _repositories.value = this
            }

            error?.apply {
                _error.value = this
            }
        }
    }
}