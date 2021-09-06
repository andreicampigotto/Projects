package com.proway.crudizin_basico.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.proway.crudizin_basico.model.Patient

@Dao
interface PatientDao {
    @Query("Select * from Patient order by name_patient")
    fun fetch(): List<Patient>

    @Query("Select * from Patient where gender = :gender")
    fun fetch(gender: String): List<Patient>

    @Insert(onConflict = ABORT)
    fun insert(list: List<Patient>)

    @Delete
    fun delete(patient: Patient)

    @Update
    fun update(patient: Patient)

    @Query("Select * from Patient where cpf_patient = :id")
    fun fetchById(id: String): Patient
}