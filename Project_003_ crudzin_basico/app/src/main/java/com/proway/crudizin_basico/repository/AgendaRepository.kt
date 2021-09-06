package com.proway.crudizin_basico.repository

import com.proway.crudizin_basico.database.dao.AgendaDao
import com.proway.crudizin_basico.model.Agenda
import com.proway.crudizin_basico.model.AgendaWhitFks
import javax.inject.Inject

class AgendaRepository @Inject constructor(
    private val agendaDao: AgendaDao,
) {

    fun getAgenda(): List<AgendaWhitFks> {
        return agendaDao.fetch()
    }

//    fun insert(List<agenda>: Agenda) {
//        return dao.insert(agenda)
//    }

    fun delete(agenda: Agenda) {
        return agendaDao.delete(agenda)
    }

    fun update(agenda: Agenda) {
        return agendaDao.update(agenda)
    }
}