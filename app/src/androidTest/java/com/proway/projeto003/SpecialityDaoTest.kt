package com.proway.projeto003

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.proway.projeto003.database.AppDatabase
import com.proway.projeto003.database.dao.SpecialityDao
import com.proway.projeto003.model.Speciality
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
        dao = database.specialityDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun testing_insert_speciality_should_return_true() {
        val newSpeciality1 = Speciality(name = "Pediatrician")
        val newSpeciality2 = Speciality(name = "Ophthalmologist")
        val newSpeciality3 = Speciality(name = "Cardiologist")

        val listToInsert = arrayListOf(newSpeciality1, newSpeciality2, newSpeciality3)
        dao.insert(listToInsert)

        val results = dao.getSpecialities()
        assertThat(results).hasSize(listToInsert.size)
    }

    @Test
    fun testing_update() {
        val newSpeciality1 = Speciality(id = 23, name = "Pediatrician")
        val newSpeciality2 = Speciality(id = 45, name = "Ophthalmologist")
        val newSpeciality3 = Speciality(id = 32, name = "Cardiologist")

        val listToInsert = arrayListOf(newSpeciality1, newSpeciality2, newSpeciality3)
        dao.insert(listToInsert)

        val specialityForUpdate = Speciality(
            id = newSpeciality3.id,
            name = "Geneticist"
        )
        dao.update(specialityForUpdate)

        val result = dao.getSpecialityById(newSpeciality3.id)
        assertThat(result.id).isEqualTo(specialityForUpdate.id)
        assertThat(result.name).isEqualTo(specialityForUpdate.name)
    }

    @Test
    fun testing_delete() {
        val newSpeciality1 = Speciality(id = 6, name = "Pediatrician")
        val newSpeciality2 = Speciality(id = 18, name = "Ophthalmologist")
        val newSpeciality3 = Speciality(id = 39, name = "Cardiologist")

        val listToInsert = arrayListOf(newSpeciality1, newSpeciality2, newSpeciality3)
        dao.insert(listToInsert)

        dao.delete(newSpeciality2)

        val result = dao.getSpecialities()
        assertThat(result).doesNotContain(newSpeciality2)
    }
}