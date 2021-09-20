package com.proway.project_four.di

import com.proway.project_four.service.PokeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
//aqui vai injecao de dependencia
object AppModule {

    //leitura do service para que a injecao de dependencia saiba na hora que precisar ler da API
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    //injecao de depencia do service para propagar no app
    @Provides
    fun providePokeApi(retrofit: Retrofit): PokeService =
        retrofit.create(PokeService::class.java)

    //@Provides


}