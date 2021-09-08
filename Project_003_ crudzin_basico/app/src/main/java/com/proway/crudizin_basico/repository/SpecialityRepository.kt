package com.proway.crudizin_basico.repository

import com.proway.crudizin_basico.database.dao.SpecialityDao
import com.proway.crudizin_basico.model.Speciality
import javax.inject.Inject

class SpecialityRepository @Inject constructor(private val specialityDao: SpecialityDao) {

    fun getSpecialities(): List<Speciality> {
        return specialityDao.fetch()
    }

    fun insert(speciality: Speciality) {
        return specialityDao.insert(arrayListOf(speciality))
    }

    fun update(speciality: Speciality) {
        return specialityDao.update(speciality)
    }

    fun delete(speciality: Speciality) {
        return specialityDao.delete(speciality)
    }
}