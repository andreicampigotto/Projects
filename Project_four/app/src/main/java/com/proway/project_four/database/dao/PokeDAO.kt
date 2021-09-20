package com.proway.project_four.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.proway.project_four.model.Pokemon
import com.proway.project_four.model.Pokemons

@Dao
interface PokeDAO {

    //Inserir no DB
    @Insert
    suspend fun insert(pokemon: Pokemon)

    @Insert
    suspend fun insert(pokemon: List<Pokemon>)

    //Lista do DB
    @Query("SELECT * FROM Pokemon")
    suspend fun fetch(): List<Pokemon>
}