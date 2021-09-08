package com.proway.crudizin_nada_basico.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.crudizin_nada_basico.model.Speciality
import com.proway.crudizin_nada_basico.repository.SpecialityRepository
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
        //usa funcao para atualizar a lista
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