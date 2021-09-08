package com.proway.crudizin_basico

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.proway.crudizin_basico.database.AppDatabase
import com.proway.crudizin_basico.database.dao.PatientDao
import com.proway.crudizin_basico.model.Patient
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
    fun testing_fetch_by_id() {
        val newPatient1 = Patient(cpf_patient = "1", name_patient = "P1", age = 10, gender = "M")
        val newPatient2 = Patient(cpf_patient = "2", name_patient = "P2", age = 22, gender = "F")
        val newPatient3 = Patient(cpf_patient = "3", name_patient = "P3", age = 22, gender = "M")
        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        val result = dao.fetch("2")
        //assertThat(result.name_patient).isEqualTo(newPatient2.name_patient)
    }

    @Test
    fun testing_update() {
        val newPatient1 = Patient(cpf_patient = "1", name_patient = "P1", age = 10, gender = "M")
        val newPatient2 = Patient(cpf_patient = "2", name_patient = "P2", age = 22, gender = "F")
        val newPatient3 = Patient(cpf_patient = "3", name_patient = "P3", age = 22, gender = "M")
        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        val patientForUpdate = Patient(
            cpf_patient = newPatient2.cpf_patient,
            name_patient = "P2Updated",
            age = 23,
            gender = "M"
        )
        dao.update(patientForUpdate)

        val result = dao.fetch(newPatient2.cpf_patient)
//        assertThat(result.name_patient).isEqualTo(patientForUpdate.name_patient)
//        assertThat(result.age).isEqualTo(patientForUpdate.age)
//        assertThat(result.gender).isEqualTo(patientForUpdate.gender)
    }

    @Test
    fun testing_delete() {
        val newPatient1 = Patient(cpf_patient = "1", name_patient = "P1", age = 10, gender = "M")
        val newPatient2 = Patient(cpf_patient = "2", name_patient = "P2", age = 22, gender = "F")
        val newPatient3 = Patient(cpf_patient = "3", name_patient = "P3", age = 22, gender = "M")
        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        dao.delete(newPatient2)

        val result = dao.fetch()
        assertThat(result).doesNotContain(newPatient2)
    }
}