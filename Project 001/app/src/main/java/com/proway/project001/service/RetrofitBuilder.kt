package com.proway.project001.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofitBeers = Retrofit.Builder()
        //https://api.punkapi.com/v2/beers
        .baseUrl("https://api.punkapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getBeerInstance(): BeersService{
        return retrofitBeers.create(BeersService::class.java)
    }

    private val retrofitDrinks = Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getDrinkInstance(): DrinkService{
        return retrofitDrinks.create(DrinkService::class.java)
    }
}