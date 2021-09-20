package com.proway.crudizin_nada_basico.repository

import com.proway.crudizin_nada_basico.database.dao.AgendaDao
import com.proway.crudizin_nada_basico.model.Agenda
import com.proway.crudizin_nada_basico.model.AgendaWhitFks
import javax.inject.Inject

class AgendaRepository @Inject constructor(
    private val agendaDao: AgendaDao,
) {

    fun getAgenda(): List<AgendaWhitFks> {
        return agendaDao.fetch()
    }

    fun getAgendaByDoctor(doctor: String): List<AgendaWhitFks> {
        return agendaDao.fetchByDoctor(doctor)
    }

    fun getByDoctorSpeciality(doctor: String): List<AgendaWhitFks> {
        return agendaDao.fetchByDoctor(doctor)
    }

    fun getByPatient(patient: String):List<AgendaWhitFks>{
        return agendaDao.fetchByPatient(patient)
    }

//    fun insert(List<Agenda>: Agenda) {
//        return dao.insert(agenda)
//    }

    fun delete(agenda: Agenda) {
        return agendaDao.delete(agenda)
    }

    fun update(agenda: Agenda) {
        return agendaDao.update(agenda)
    }
}