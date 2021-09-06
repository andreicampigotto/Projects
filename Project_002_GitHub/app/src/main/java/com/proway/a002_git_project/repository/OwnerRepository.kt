package com.proway.a002_git_project.repository

import com.proway.a002_git_project.model.Owner
import com.proway.a002_git_project.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OwnerRepository {

    private val serviceOwner = RetrofitService.getOwners()

    fun getOwners(onComplete: (List<Owner>?, String?) -> Unit) {
        val call = serviceOwner.getOwner()

        call.enqueue(object : Callback<Owner> {
            override fun onResponse(call: Call<Owner>, response: Response<Owner>) {
                if (response.body() != null) {
                    //onComplete(response.body(), null)
                } else {
                    onComplete(null, "Error")
                }
            }

            override fun onFailure(call: Call<Owner>, t: Throwable) {
                onComplete(null, t.localizedMessage)
            }

        })

    }

}