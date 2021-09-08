package com.proway.crudizin_basico.model

import androidx.room.*

@Entity
data class Patient(

    @PrimaryKey
    @ColumnInfo(name = "cpf_patient")
    val cpf_patient: String,

    @ColumnInfo(name = "name_patient")
    val name_patient: String,

    @ColumnInfo(name = "age")
    val age: Int,

    @ColumnInfo(name = "gender")
    val gender: String
) {
}