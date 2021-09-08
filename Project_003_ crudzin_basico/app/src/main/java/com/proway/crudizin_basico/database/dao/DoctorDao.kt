package com.proway.crudizin_basico.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.proway.crudizin_basico.model.*

@Dao
interface DoctorDao {
    @Transaction
    @Query("Select * from Doctor order by name_doctor")
    fun fetch(): List<DoctorWithSpeciality>

    @Transaction
    @Query("Select * from Doctor where name_doctor like '%' || :name || '%'")
    fun fetch(name: String): List<DoctorWithSpeciality>

    @Insert(onConflict = ABORT)
    fun insert(doctor: Doctor)

    @Delete
    fun delete(doctor: Doctor)

    @Update
    fun update(doctor: Doctor)

    @Transaction
    @Query("Select * from Doctor where crm_doctor = :id")
    fun fetchById(id: String): DoctorWithSpeciality

}