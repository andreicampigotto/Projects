package com.proway.crudizin_nada_basico

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.proway.crudizin_nada_basico.database.AppDatabase
import com.proway.crudizin_nada_basico.database.dao.SpecialityDao
import com.proway.crudizin_nada_basico.model.Speciality
import org.junit.After
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class SpecialityDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: SpecialityDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.getSpecialityDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun testing_insert() {
        val spe1 = Speciality(name = "S1")
        val spe2 = Speciality(name = "S2")
        val listToInsert = arrayListOf(spe1, spe2)
        dao.insert(listToInsert)

        val results = dao.fetch()
        assertThat(results).hasSize(listToInsert.size)
    }

    @Test
    fun testing_fetch_by_name() {
        val spe1 = Speciality(name = "S1")
        val spe2 = Speciality(name = "S2AA")
        val listToInsert = arrayListOf(spe1, spe2)
        dao.insert(listToInsert)

        val results = dao.fetch("AA")
        assertThat(results).hasSize(1)
    }

    @Test
    fun testing_fetch_by_id() {
        val spe1 = Speciality(id_specialty = 1,name = "S1")
        val spe2 = Speciality(id_specialty = 2, name = "S2AA")
        val listToInsert = arrayListOf(spe1, spe2)
        dao.insert(listToInsert)

        val result = dao.fetch(2)
        assertThat(result.name).isEqualTo(spe2.name)
    }

    @Test
    fun testing_update() {
        val spe1 = Speciality(id_specialty = 1,name = "S1")
        val spe2 = Speciality(id_specialty = 2, name = "S2AA")
        val listToInsert = arrayListOf(spe1, spe2)
        dao.insert(listToInsert)

        val speForUpdate = Speciality(
            id_specialty = spe2.id_specialty,
            name = "SPE2Updated"
        )
        dao.update(speForUpdate)

        val result = dao.fetch(spe2.id_specialty)
        assertThat(result.name).isEqualTo(speForUpdate.name)
    }

    @Test
    fun testing_delete() {
        val spe1 = Speciality(id_specialty = 1,name = "S1")
        val spe2 = Speciality(id_specialty = 2, name = "S2AA")
        val listToInsert = arrayListOf(spe1, spe2)
        dao.insert(listToInsert)

        dao.delete(spe1)

        val result = dao.fetch()
        assertThat(result).doesNotContain(spe1)
    }
}