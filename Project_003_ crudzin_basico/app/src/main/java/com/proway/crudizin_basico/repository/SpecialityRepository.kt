package com.proway.crudizin_basico.repository

import com.proway.crudizin_basico.database.AppDatabase
import com.proway.crudizin_basico.database.dao.SpecialityDao
import com.proway.crudizin_basico.model.Speciality

class SpecialityRepository {
    private val dao: SpecialityDao = AppDatabase.getDatabase().getSpecialityDao()

    fun getSpecialities(): List<Speciality> {
        return dao.fetch()
    }

    fun insert(speciality: Speciality) {
        return dao.insert(arrayListOf(speciality))
    }

    fun update(speciality: Speciality) {
        return dao.update(speciality)
    }

    fun delete(speciality: Speciality) {
        return dao.delete(speciality)
    }
}