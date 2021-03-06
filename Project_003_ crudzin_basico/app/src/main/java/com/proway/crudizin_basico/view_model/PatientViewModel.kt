package com.proway.crudizin_basico.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.crudizin_basico.model.Patient
import com.proway.crudizin_basico.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PatientViewModel @Inject constructor(
    private val patientRepository: PatientRepository
) : ViewModel() {

    private val _patient = MutableLiveData<List<Patient>>()
    val patient: LiveData<List<Patient>> = _patient

    fun getAllPatient() {
        _patient.value = patientRepository.getPatients()
    }

    fun insertPatient(patient: Patient) {
        patientRepository.insert(patient)
        getAllPatient()
    }

    fun updatePatient(patient: Patient) {
        patientRepository.update(patient)
        getAllPatient()
    }

    fun deletePatient(patient: Patient) {
        patientRepository.delete(patient)
        getAllPatient()
    }
}