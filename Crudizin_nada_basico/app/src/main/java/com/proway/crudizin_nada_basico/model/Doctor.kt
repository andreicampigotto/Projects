package com.proway.crudizin_nada_basico.model

import androidx.room.*

@Entity
data class Doctor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "doc_id")
    var id: Int = 0,

    @ColumnInfo(name = "name_doctor")
    val name_doctor: String,

    val speciality_fk: Long,
)
data class DoctorWithSpeciality(
    @Embedded
    val doctor: Doctor,

    @Relation(
        parentColumn = "speciality_fk",
        entityColumn = "id_specialty"
    )
    val speciality: Speciality,
)