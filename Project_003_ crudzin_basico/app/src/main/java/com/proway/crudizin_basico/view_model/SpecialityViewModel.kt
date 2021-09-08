package com.proway.crudizin_basico.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.crudizin_basico.model.Speciality
import com.proway.crudizin_basico.repository.SpecialityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpecialityViewModel @Inject constructor(private val specialityRepository: SpecialityRepository) :
    ViewModel() {

    private val _speciality = MutableLiveData<List<Speciality>>()
    val speciality: LiveData<List<Speciality>> = _speciality

    fun getAllSpecialisties() {
        _speciality.value = specialityRepository.getSpecialities()
    }

    fun insertSpeciality(speciality: Speciality) {
        specialityRepository.insert(speciality)
        getAllSpecialisties()
    }

    fun updateSpeciality(speciality: Speciality) {
        specialityRepository.update(speciality)
        getAllSpecialisties()
    }

    fun deleteSpeciality(speciality: Speciality) {
        specialityRepository.delete(speciality)
        getAllSpecialisties()
    }
}