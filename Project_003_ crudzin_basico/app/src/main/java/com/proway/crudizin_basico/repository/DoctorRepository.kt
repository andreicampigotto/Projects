package com.proway.crudizin_basico.repository

import com.proway.crudizin_basico.database.AppDatabase
import com.proway.crudizin_basico.database.dao.DoctorDao
import com.proway.crudizin_basico.model.Doctor
import com.proway.crudizin_basico.model.DoctorWithSpeciality

class DoctorRepository {

    private val dao: DoctorDao = AppDatabase.getDatabase().getDoctorDao()

    fun getDoctors(): List<DoctorWithSpeciality> {
        return dao.fetch()
    }

//    fun insert(doctor: Doctor) {
//        return dao.insert(doctor)
//    }

    fun delete(doctor: Doctor) {
        return dao.delete(doctor)
    }

    fun update(doctor: Doctor) {
        return dao.update(doctor)
    }
}