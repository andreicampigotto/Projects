package com.proway.crudizin_nada_basico.database.dao


import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.proway.crudizin_nada_basico.model.Agenda
import com.proway.crudizin_nada_basico.model.AgendaWhitFks

@Dao
interface AgendaDao {
    @Transaction
    @Query("Select * from Agenda a, Doctor d where a.doctor_fk = d.doc_id order by d.name_doctor")
    fun fetch(): List<AgendaWhitFks>

    @Transaction
    @Query("Select * from Agenda where id_agenda = :id")
    fun fetchById(id: String): AgendaWhitFks

    @Transaction
    @Query("Select * from Agenda inner join Doctor on doctor.doc_id = doctor_fk where doctor.name_doctor like '%' || :name || '%'")
    fun fetchByDoctor(name: String): List<AgendaWhitFks>

    @Transaction
    @Query("Select * from Agenda inner join Doctor on doctor.doc_id = doctor_fk where doctor.speciality_fk in (:ids)")
    fun fetchByDoctorSpeciality(ids: List<String>): List<AgendaWhitFks>

    @Transaction
    @Query("Select * from Agenda inner join Patient on patient.pat_id = patient_fk where patient.name_patient like '%' || :name || '%'")
    fun fetchByPatient(name: String): List<AgendaWhitFks>

    @Transaction
    @Query("Select * from Agenda inner join Patient on patient.pat_id = patient_fk where gender = :gender")
    fun fetchByGender(gender: String): List<AgendaWhitFks>

    @Insert(onConflict = ABORT)
    fun insert(list: List<Agenda>)

    @Delete
    fun delete(scheduling: Agenda)

    @Update
    fun update(scheduling: Agenda)
}