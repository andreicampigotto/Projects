package com.proway.a002_git_project.services

import com.proway.a002_git_project.model.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface RepositoryService {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getRepositories(): Call<RepositoryResponse>
}