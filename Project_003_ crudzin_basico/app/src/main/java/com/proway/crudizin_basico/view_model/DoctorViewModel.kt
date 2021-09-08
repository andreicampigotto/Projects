package com.proway.crudizin_basico.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.crudizin_basico.model.Doctor
import com.proway.crudizin_basico.model.DoctorWithSpeciality
import com.proway.crudizin_basico.model.Speciality
import com.proway.crudizin_basico.repository.DoctorRepository
import com.proway.crudizin_basico.repository.SpecialityRepository
import javax.inject.Inject

class DoctorViewModel @Inject constructor(
    private val doctorRepository: DoctorRepository,
    private val specialityRepository: SpecialityRepository
) : ViewModel() {

    private val _doctor = MutableLiveData<List<DoctorWithSpeciality>>()
    val doctor: LiveData<List<DoctorWithSpeciality>> = _doctor

    private val _speciality = MutableLiveData<List<Speciality>>()
    val specialist: LiveData<List<Speciality>> = _speciality

    private fun getAllDoctors() {
        _doctor.value = doctorRepository.getDoctor()
    }

    fun insertDoctor(doctor: Doctor) {
        doctorRepository.insert(doctor)
        getAllDoctors()
    }

    fun updateDoctor(doctor: Doctor) {
        doctorRepository.update(doctor)
        getAllDoctors()
    }

    fun deleteDoctor(doctor: Doctor) {
        doctorRepository.delete(doctor)
        getAllDoctors()
    }

    fun getSpecialist() {
        _speciality.value = specialityRepository.getSpecialities()
    }
}