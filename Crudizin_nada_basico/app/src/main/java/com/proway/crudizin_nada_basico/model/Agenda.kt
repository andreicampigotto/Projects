package com.proway.crudizin_nada_basico.model

import androidx.room.*
@Entity
data class Agenda(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_agenda")
    val id_agenda: Long,

    val doctor_fk: String,

    val patient_fk: String
)

data class AgendaWhitFks(
    @Embedded
    val agenda: Agenda,
    @Relation(
        parentColumn = "doctor_fk",
        entityColumn = "doc_id"
    )
    val doctor: Doctor,

    @Relation(
        parentColumn = "patient_fk",
        entityColumn = "pat_id"
    )
    val patient: Patient
)

