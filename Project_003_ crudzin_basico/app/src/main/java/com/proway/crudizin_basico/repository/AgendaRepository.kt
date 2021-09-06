package com.proway.crudizin_basico.repository

import com.proway.crudizin_basico.database.AppDatabase
import com.proway.crudizin_basico.database.dao.AgendaDao
import com.proway.crudizin_basico.model.Agenda
import com.proway.crudizin_basico.model.AgendaWhitFks
class AgendaRepository {

    private val dao: AgendaDao = AppDatabase.getDatabase().getAgendaDao()

    fun getAgenda(): List<AgendaWhitFks> {
        return dao.fetch()
    }

//    fun insert(List<agenda>: Agenda) {
//        return dao.insert(agenda)
//    }

    fun delete(agenda: Agenda) {
        return dao.delete(agenda)
    }

    fun update(agenda: Agenda) {
        return dao.update(agenda)
    }
}