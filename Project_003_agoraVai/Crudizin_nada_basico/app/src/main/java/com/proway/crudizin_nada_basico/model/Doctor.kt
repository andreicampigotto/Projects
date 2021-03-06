package com.proway.crudizin_nada_basico.model

import androidx.room.*

@Entity
data class Doctor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "doc_id")
    var doc_id: Int = 0,

    @ColumnInfo(name = "name_doctor")
    val name_doctor: String,

    val speciality_fk: Int,
)
data class DoctorWithSpeciality(

    @Embedded
    val doctor: Doctor?,

    @Relation(
        parentColumn = "speciality_fk",
        entityColumn = "id_speciality"
    )
    val speciality: Speciality?,
)