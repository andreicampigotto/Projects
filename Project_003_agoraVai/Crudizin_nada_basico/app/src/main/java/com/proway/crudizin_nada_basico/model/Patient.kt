package com.proway.crudizin_nada_basico.model

import androidx.room.*

@Entity
data class Patient(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pat_id")
    var pat_id: Int = 0,

    @ColumnInfo(name = "name_patient")
    val name_patient: String,

    @ColumnInfo(name = "age")
    val age: Int,

    @ColumnInfo(name = "gender")
    val gender: String
) {
}