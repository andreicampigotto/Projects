package com.proway.project_four.service

import com.proway.project_four.model.Pokemons
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

//interface que carrega o endpoint
interface PokeService {
    @GET("/api/v2/pokemon")
    suspend fun getAll(): Response<Pokemons>
}