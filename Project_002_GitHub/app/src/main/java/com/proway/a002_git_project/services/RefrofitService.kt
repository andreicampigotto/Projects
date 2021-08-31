package com.proway.a002_git_project.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRepositories() : RepositoryService = retrofit.create(RepositoryService::class.java)

    fun getPulls(): PullService = retrofit.create(PullService::class.java)
}

