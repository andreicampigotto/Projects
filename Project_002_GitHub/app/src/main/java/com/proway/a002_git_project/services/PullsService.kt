package com.proway.a002_git_project.services

import com.proway.a002_git_project.model.PullRequestResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PullsService {

    @GET("https://api.github.com/repos/{fullName}/pulls")
    fun getPullRequestsList(@Path("fullName") fullName: String): Call<List<PullRequestResponse>>

}