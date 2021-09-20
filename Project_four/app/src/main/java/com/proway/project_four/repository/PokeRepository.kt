package com.proway.project_four.repository

import com.proway.project_four.database.dao.PokeDAO
import com.proway.project_four.model.Pokemon
import com.proway.project_four.model.Pokemons
import com.proway.project_four.service.PokeService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

//repositorio com as depencias injetadas tanto do service, que vem da api quanto do dao que sao as infos vindas do db
class PokeRepository @Inject constructor(
    private val service: PokeService,
    private val pokeDAO: PokeDAO
) {

    //funcao que carrega as informacoes vindas do service
    suspend fun fetchPokemons(): Pokemons? {
        // withContext o bloco que sera suspendido aqui vai esperar
        return withContext(Dispatchers.Default) {
            val response = service.getAll()
            // porque quando coloca response no service quebra aqui?
            val processedResponse = processData(response)
            processedResponse
        }
    }

    //funcao generica para processamento de respostas
    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }

    //acessando a lista vinda do dao
    suspend fun fetchFromDb(): List<Pokemon> {
        return withContext(Dispatchers.Default) {
            pokeDAO.fetch()
        }
    }

    //withContext ele ja eh o proprio async e await
    suspend fun insert(listOf: List<Pokemon>) : Boolean {
        return withContext(Dispatchers.Default) {
            pokeDAO.insert(listOf)
            true
        }
    }

}