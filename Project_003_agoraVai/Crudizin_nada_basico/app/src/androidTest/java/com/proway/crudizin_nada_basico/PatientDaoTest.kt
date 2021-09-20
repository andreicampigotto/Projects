package com.proway.crudizin_nada_basico


import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.proway.crudizin_nada_basico.database.AppDatabase
import com.proway.crudizin_nada_basico.database.dao.PatientDao
import com.proway.crudizin_nada_basico.model.Patient
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class PatientDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: PatientDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.getPatientDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun testing_insert_patient_should_returns_true() {
        val newPatient1 = Patient(name_patient = "P1", age = 10, gender = "M")
        val newPatient2 = Patient(name_patient = "P2", age = 22, gender = "F")
        val listToInsert = arrayListOf(newPatient1, newPatient2)
        dao.insert(listToInsert)

        val results = dao.fetch()
        assertThat(results).hasSize(listToInsert.size)
    }

    @Test
    fun testing_fetch_by_gender() {
        val newPatient1 = Patient(name_patient = "P1", age = 10, gender = "M")
        val newPatient2 = Patient(name_patient = "P2", age = 22, gender = "F")
        val newPatient3 = Patient(name_patient = "P3", age = 22, gender = "M")
        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        val results = dao.fetch("F")
        assertThat(results).hasSize(1)
    }

    @Test
    fun testing_delete() {
        val newPatient1 = Patient(pat_id = 1, name_patient = "P1", age = 10, gender = "M")
        val newPatient2 = Patient(pat_id = 2, name_patient = "P2", age = 22, gender = "F")
        val newPatient3 = Patient(pat_id = 3, name_patient = "P3", age = 22, gender = "M")
        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        dao.delete(newPatient2)

        val result = dao.fetch()
        assertThat(result).doesNotContain(newPatient2)
    }
}