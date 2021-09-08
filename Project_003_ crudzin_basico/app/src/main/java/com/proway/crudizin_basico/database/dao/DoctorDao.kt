package com.proway.crudizin_basico.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.proway.crudizin_basico.model.*

@Dao
interface DoctorDao {

    @Transaction
    @Query("Select * from Doctor")
    fun fetch(): List<DoctorWithSpeciality>

    @Insert(onConflict = ABORT)
    fun insert(doctor: Doctor)

    @Delete
    fun delete(doctor: Doctor)

    @Update
    fun update(doctor: Doctor)
}