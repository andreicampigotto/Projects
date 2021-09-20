package com.proway.crudizin_nada_basico.repository


import com.proway.crudizin_nada_basico.database.dao.DoctorDao
import com.proway.crudizin_nada_basico.model.Doctor
import com.proway.crudizin_nada_basico.model.DoctorWithSpeciality
import javax.inject.Inject

class DoctorRepository @Inject constructor(private val doctorDao: DoctorDao) {

    fun getDoctor(): List<DoctorWithSpeciality> {
        return doctorDao.fetch()
    }

    fun insert(doctor: Doctor) {
        return doctorDao.insert(doctor)
    }

    fun delete(doctor: Doctor) {
        return doctorDao.delete(doctor)
    }

    fun update(doctor: Doctor) {
        return doctorDao.update(doctor)
    }
}