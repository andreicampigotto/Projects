package com.proway.a002_git_project.repository

import com.proway.a002_git_project.model.Repository
import com.proway.a002_git_project.model.RepositoryResponse
import com.proway.a002_git_project.services.RefrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepository {
    private val serviceRepository = RefrofitService.getRepositories()

    fun getRepositoriesList(onComplete: (List<Repository>?, String?) -> Unit) {
        val call = serviceRepository.getRepositories()

        call.enqueue(object : Callback<List<RepositoryResponse>> {
            override fun onResponse(call: Call<List<RepositoryResponse>>, response: Response<List<RepositoryResponse>>
            ) {
                if (response.body() != null) {
//                    onComplete(response.body(), null)
                } else {
                    onComplete(null, "Ocorreu um erro")
                }
            }
            override fun onFailure(call: Call<List<RepositoryResponse>>, t: Throwable) {
            }
        })
    }

}