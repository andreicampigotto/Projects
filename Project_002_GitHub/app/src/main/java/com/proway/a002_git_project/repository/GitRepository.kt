package com.proway.a002_git_project.repository

import com.proway.a002_git_project.model.Repository
import com.proway.a002_git_project.model.RepositoryResponse
import com.proway.a002_git_project.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepository {
    private val serviceRepository = RetrofitService.getRepositories()

    fun getRepositoriesList(language: String, sort: String, page:Int, onComplete: (List<Repository>?, String?) -> Unit) {
        val call = serviceRepository.getRepositories(language = "language:$language",
            sort = sort,
            page = page)

        call.enqueue(object : Callback<RepositoryResponse>{
            override fun onResponse(
                call: Call<RepositoryResponse>,
                response: Response<RepositoryResponse>
            ) {
                if (response.body() != null) {
                    onComplete(response.body()!!.items, null)
                } else {
                    onComplete(null, "Error")
                }
            }

            override fun onFailure(call: Call<RepositoryResponse>, t: Throwable) {
                onComplete(null, t.localizedMessage)
            }
        })
    }


}