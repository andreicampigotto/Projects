package com.proway.crudizin_basico.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.crudizin_basico.model.Speciality
import com.proway.crudizin_basico.repository.SpecialityRepository
import javax.inject.Inject

class SpecialityViewModel @Inject constructor(private val specialityRepository: SpecialityRepository) :
    ViewModel() {

    private val _speciality = MutableLiveData<List<Speciality>>()
    val speciality: LiveData<List<Speciality>> = _speciality

    fun getAllSpecialisties() {
        _speciality.value = specialityRepository.getSpecialities()
    }

    fun insertSpecialist(speciality: Speciality) {
        specialityRepository.insert(speciality)
        getAllSpecialisties()
    }

    fun updateSpecialist(speciality: Speciality) {
        specialityRepository.update(speciality)
        getAllSpecialisties()
    }

    fun deleteSpecialist(speciality: Speciality) {
        specialityRepository.delete(speciality)
        getAllSpecialisties()
    }
}