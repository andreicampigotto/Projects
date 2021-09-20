package com.proway.project_four.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//classe que vai retornar uma lista como visto no endpoint
data class Pokemons(
    val results: List<Pokemon>
) {}

//mapeamento de entidade para gerar db e leitura do que e requisitado da api
@Entity
data class Pokemon(
    @PrimaryKey
    val name: String,
    val url: String,
)