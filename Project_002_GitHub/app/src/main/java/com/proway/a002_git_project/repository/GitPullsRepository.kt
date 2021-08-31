package com.proway.a002_git_project.repository

import com.proway.a002_git_project.model.PullRequestResponse
import com.proway.a002_git_project.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitPullsRepository {

    private val servicePull = RetrofitService.getPulls()

    fun getPulls(fullName: String, onComplete: (List<PullRequestResponse>?, String?) -> Unit) {

        val call = servicePull.getPullRequestsList(fullName = fullName)

        call.enqueue(object : Callback<List<PullRequestResponse>>{
            override fun onResponse(
                call: Call<List<PullRequestResponse>>,
                response: Response<List<PullRequestResponse>>
            ) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<List<PullRequestResponse>>, t: Throwable) {
                onComplete(null, t.localizedMessage)
            }

        })
    }
}


