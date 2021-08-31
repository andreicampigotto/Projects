package com.proway.a002_git_project.repository

import com.proway.a002_git_project.model.Pull
import com.proway.a002_git_project.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitPullsRepository {

    private val servicePull = RetrofitService.getPulls()

    fun getPulls(fullName: String, onComplete: (List<Pull>?, String?) -> Unit) {

        val call = servicePull.getPullRequestsList(fullName = fullName)

        call.enqueue(object : Callback<List<Pull>>{
            override fun onResponse(
                call: Call<List<Pull>>,
                response: Response<List<Pull>>
            ) {
                if (response.body() != null) {
                    onComplete(response.body()!!, null)
                } else {
                    onComplete(null, "Error")
                }
            }

            override fun onFailure(call: Call<List<Pull>>, t: Throwable) {
                onComplete(null, t.localizedMessage)
            }
        })
    }
}


