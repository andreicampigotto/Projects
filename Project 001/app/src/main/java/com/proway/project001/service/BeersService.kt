package com.proway.project001.service

import com.proway.project001.model.Beer
import retrofit2.Call
import retrofit2.http.GET

interface BeersService {
    @GET("/v2/beers")
    fun getBeers(): Call<List<Beer>>
}