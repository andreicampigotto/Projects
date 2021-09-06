package com.proway.crudizin_basico.model

import androidx.room.*

@Entity
data class Doctor(
    @PrimaryKey
    @ColumnInfo(name = "crm_doctor")
    val crm_doctor: String,

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