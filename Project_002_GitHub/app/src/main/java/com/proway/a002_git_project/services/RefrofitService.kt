package com.proway.a002_git_project.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RefrofitService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}

