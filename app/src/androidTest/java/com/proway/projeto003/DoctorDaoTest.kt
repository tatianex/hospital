package com.proway.projeto003

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.proway.projeto003.database.AppDatabase
import com.proway.projeto003.database.dao.DoctorDao
import com.proway.projeto003.model.Doctor
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class DoctorDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: DoctorDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.doctorDao()

    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun testing_insert_doctor_should_return_true() {
        val newDoctor1 = Doctor(name = "José", specialityPK = 1)
        val newDoctor2 = Doctor(name = "Umberto", specialityPK = 2)
        val newDoctor3 = Doctor(name = "Maria", specialityPK = 1)
        val listToInsert = arrayListOf(newDoctor1, newDoctor2, newDoctor3)
        dao.insert(listToInsert)

        val results = dao.getDoctors()
        assertThat(results).hasSize(listToInsert.size)
    }

    @Test
    fun testing_get_by_name() {
        val newDoctor1 = Doctor(id = 16, name = "Arthur", specialityPK = 3)
        val newDoctor2 = Doctor(id = 20, name = "Ana", specialityPK = 3)
        val newDoctor3 = Doctor(id = 18, name = "Joaquim", specialityPK = 4)

        val listToInsert = arrayListOf(newDoctor1, newDoctor2, newDoctor3)
        dao.insert(listToInsert)

        val result = dao.getDoctorByName("Ana")
    }

    @Test
    fun testing_get_by_id() {
        val newDoctor1 = Doctor(id = 1, name = "Tatiane", specialityPK = 1)
        val newDoctor2 = Doctor(id = 204, name = "Carolina", specialityPK = 2)
        val newDoctor3 = Doctor(id = 56, name = "Eduardo", specialityPK = 4)

        val listToInsert = arrayListOf(newDoctor1, newDoctor2, newDoctor3)
        dao.insert(listToInsert)

        val result = dao.getDoctorById(204)
        assertThat(result.doctor?.id).isEqualTo(newDoctor2.id)
    }

    @Test
    fun testing_update() {
        val newDoctor1 = Doctor(id = 98, name = "Matheus", specialityPK = 2)
        val newDoctor2 = Doctor(id = 10, name = "Laura", specialityPK = 3)
        val newDoctor3 = Doctor(id = 5, name = "Thiago", specialityPK = 1)

        val listToInsert = arrayListOf(newDoctor1, newDoctor2, newDoctor3)
        dao.insert(listToInsert)

        val doctorForUpdate = Doctor(
            id = newDoctor1.id,
            name = "Luisa",
            specialityPK = 4
        )
        dao.update(doctorForUpdate)

        val result = dao.getDoctorById(newDoctor1.id)
        assertThat(result.doctor?.id).isEqualTo(doctorForUpdate.id)
        assertThat(result.doctor?.name).isEqualTo(doctorForUpdate.name)
        assertThat(result.doctor?.specialityPK).isEqualTo(doctorForUpdate.specialityPK)
    }

    @Test
    fun testing_delete() {
        val newDoctor1 = Doctor(id = 19, name = "Joana", specialityPK =1)
        val newDoctor2 = Doctor(id = 38, name = "Iago", specialityPK = 2)
        val newDoctor3 = Doctor(id = 52, name = "Yasmin", specialityPK = 3)

        val listToInsert = arrayListOf(newDoctor1, newDoctor2, newDoctor3)
        dao.insert(listToInsert)

        dao.delete(newDoctor1)

        val result = dao.getDoctors()
        assertThat(result).doesNotContain(newDoctor1)
    }
}