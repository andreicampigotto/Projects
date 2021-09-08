package com.proway.crudizin_nada_basico.model

import androidx.room.*

@Entity
data class Speciality(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_specialty")
    val id_specialty: Int = 0,

    @ColumnInfo(name = "name_specialty")
    val name: String
) {}