package com.proway.crudizin_basico.repository

import com.proway.crudizin_basico.database.AppDatabase
import com.proway.crudizin_basico.database.dao.PatientDao
import com.proway.crudizin_basico.model.Patient

class PatientRepository {

    //private val dao: SpecialityDao = AppDatabase.getDatabase().getSpecialityDao()
    private val dao: PatientDao = AppDatabase.getDatabase().getPatientDao()

    fun getPatients(): List<Patient> {
        return dao.fetch()
    }

    fun insert(patient: Patient) {
        return dao.insert(arrayListOf(patient))
    }

    fun update(patient: Patient) {
        return dao.update(patient)
    }

    fun delete(patient: Patient) {
        return dao.delete(patient)
    }
}