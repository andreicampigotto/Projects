package com.proway.crudizin_nada_basico.repository

import com.proway.crudizin_nada_basico.database.dao.PatientDao
import com.proway.crudizin_nada_basico.model.Patient
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

class PatientRepository @Inject constructor(
    private val patientDao: PatientDao,
) {

    fun getPatients(): List<Patient> {
        return patientDao.fetch()
    }

    fun insert(patient: Patient) {
        return patientDao.insert(arrayListOf(patient))
    }

    fun update(patient: Patient) {
        return patientDao.update(patient)
    }

    fun delete(patient: Patient) {
        return patientDao.delete(patient)
    }
}