package com.proway.a002_git_project.services

import com.proway.a002_git_project.model.Owner
import retrofit2.Call
import retrofit2.http.GET

interface OwnerService {
    @GET("/users/")
    fun getOwner(): Call<Owner>
}