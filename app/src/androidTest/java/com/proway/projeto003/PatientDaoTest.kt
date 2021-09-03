package com.proway.projeto003

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.proway.projeto003.database.AppDatabase
import com.proway.projeto003.database.dao.PatientDao
import com.proway.projeto003.model.Patient
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
        dao = database.patientDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun testing_insert_patient_should_return_true() {
        val newPatient1 = Patient(name = "José", age = 28, gender = "M")
        val newPatient2 = Patient(name = "Umberto", age = 19, gender = "M")
        val newPatient3 = Patient(name = "Vilma", age = 32, gender = "F")
        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        val results = dao.getPatients()
        assertThat(results).hasSize(listToInsert.size)

    }

    @Test
    fun testing_get_by_id() {
        val newPatient1 = Patient(id = 1, name = "Mauricio", age = 21, gender = "M")
        val newPatient2 = Patient(id = 2, name = "Tatiane", age = 29, gender = "F")
        val newPatient3 = Patient(id = 3, name = "Maria", age = 39, gender = "F")

        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        val result = dao.getPatientById(2)
        assertThat(result.name).isEqualTo(newPatient2.name)
    }

    @Test
    fun testing_get_by_gender() {
        val newPatient1 = Patient(name = "Leila", age = 44, gender = "F")
        val newPatient2 = Patient(name = "Melissa", age = 17, gender = "F")
        val newPatient3 = Patient(name = "Roger", age = 75, gender = "M")

        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        val results = dao.getPatientByGender("F")
        assertThat(results).hasSize(2)
    }

    @Test
    fun testing_update() {
        val newPatient1 = Patient(id = 1, name = "Teresa", age = 42, gender = "F")
        val newPatient2 = Patient(id = 2, name = "José Roberto", age = 20, gender = "M")
        val newPatient3 = Patient(id = 3, name = "Francisco", age = 26, gender = "M")

        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        val patientForUpdate = Patient(
            id = newPatient3.id,
            name = "Antônio",
            age = 37,
            gender = "M"
        )
        dao.update(patientForUpdate)

        val result = dao.getPatientById(newPatient3.id)
        assertThat(result.name).isEqualTo(patientForUpdate.name)
        assertThat(result.age).isEqualTo(patientForUpdate.age)
        assertThat(result.gender).isEqualTo(patientForUpdate.gender)
    }

    @Test
    fun testing_delete() {
        val newPatient1 = Patient(id = 1, name = "Pedro", age = 23, gender = "M")
        val newPatient2 = Patient(id = 2, name = "Eduardo", age = 28, gender = "M")
        val newPatient3 = Patient(id = 3, name = "Yasmin", age = 22, gender = "F")

        val listToInsert = arrayListOf(newPatient1, newPatient2, newPatient3)
        dao.insert(listToInsert)

        dao.delete(newPatient1)

        val result = dao.getPatients()
        assertThat(result).doesNotContain(newPatient1)
    }
}