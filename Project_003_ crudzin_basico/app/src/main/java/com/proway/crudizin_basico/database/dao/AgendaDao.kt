package com.proway.crudizin_basico.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.proway.crudizin_basico.model.Agenda
import com.proway.crudizin_basico.model.AgendaWhitFks

@Dao
interface AgendaDao {
    @Transaction
    @Query("Select * from Agenda a, Doctor d where a.doctor_fk = d.crm_doctor order by d.name_doctor")
    fun fetch(): List<AgendaWhitFks>

    @Transaction
    @Query("Select * from Agenda where id_agenda = :id")
    fun fetch(id: Int): AgendaWhitFks

    @Transaction
    @Query("Select * from Agenda inner join Doctor on doctor.crm_doctor = doctor_fk where doctor.name_doctor like '%' || :name || '%'")
    fun fetchByPhysician(name: String): List<AgendaWhitFks>

    @Transaction
    @Query("Select * from Agenda inner join Doctor on doctor.crm_doctor = doctor_fk where doctor.speciality_fk in (:ids)")
    fun fetchByPhysicianSpeciality(ids: List<Int>): List<AgendaWhitFks>

    @Transaction
    @Query("Select * from Agenda inner join Patient on patient.cpf_patient = patient_fk where patient.name_patient like '%' || :name || '%'")
    fun fetchByPatient(name: String): List<AgendaWhitFks>

    @Transaction
    @Query("Select * from Agenda inner join Patient on patient.cpf_patient = patient_fk where gender = :gender")
    fun fetchByGender(gender: String): List<AgendaWhitFks>

    @Insert(onConflict = ABORT)
    fun insert(list: List<Agenda>)

    @Delete
    fun delete(scheduling: Agenda)

    @Update
    fun update(scheduling: Agenda)
}