package com.proway.crudizin_nada_basico.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.proway.crudizin_nada_basico.model.Patient
import com.proway.crudizin_nada_basico.model.Speciality

@Dao
interface PatientDao {
    @Query("Select * from Patient order by name_patient")
    fun fetch(): List<Patient>

    @Query("Select * from Patient where pat_id = :id")
    fun fetch(id: Int): Speciality

    @Query("Select * from Patient where gender = :gender")
    fun fetch(gender: String): List<Patient>

    @Insert(onConflict = ABORT)
    fun insert(list: List<Patient>)

    @Delete
    fun delete(patient: Patient)

    @Update
    fun update(patient: Patient)
}