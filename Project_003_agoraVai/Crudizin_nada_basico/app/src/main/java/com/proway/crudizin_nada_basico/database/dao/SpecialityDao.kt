package com.proway.crudizin_nada_basico.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.proway.crudizin_nada_basico.model.Speciality

@Dao
interface SpecialityDao {
    @Query("Select * from Speciality order by name_speciality")
    fun fetch(): List<Speciality>

    @Query("Select * from Speciality where id_speciality = :id")
    fun fetch(id: Int): Speciality

    @Query("Select * from Speciality where name_speciality like '%' || :name || '%'")
    fun fetch(name: String): List<Speciality>

    @Insert(onConflict = ABORT)
    fun insert(list: List<Speciality>)

    @Delete
    fun delete(speciality: Speciality)

    @Update
    fun update(speciality: Speciality)
}