package com.proway.a002_git_project.services

import android.view.textclassifier.TextLanguage
import com.proway.a002_git_project.model.RepositoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoryService {

    @GET("/search/repositories")
    fun getRepositories(
        @Query("q") language: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
    ): Call<RepositoryResponse>
}