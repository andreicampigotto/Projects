package com.proway.project001.service

import com.proway.project001.model.Drink
import com.proway.project001.model.DrinksResponse
import retrofit2.Call
import retrofit2.http.GET

interface DrinkService {
    @GET("/api/json/v1/1/random.php")
    fun getDrink(): Call<DrinksResponse>
}