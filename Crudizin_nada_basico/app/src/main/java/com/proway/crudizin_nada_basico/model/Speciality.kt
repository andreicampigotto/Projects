package com.proway.crudizin_nada_basico.model

import androidx.room.*

@Entity
data class Speciality(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_speciality")
    val id_speciality: Int = 0,

    @ColumnInfo(name = "name_speciality")
    val name: String
) {}