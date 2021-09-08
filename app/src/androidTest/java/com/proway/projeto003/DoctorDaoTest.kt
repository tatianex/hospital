//package com.proway.projeto003
//
//import androidx.room.Room
//import androidx.test.core.app.ApplicationProvider
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import androidx.test.filters.SmallTest
//import com.google.common.truth.Truth.assertThat
//import com.proway.projeto003.database.AppDatabase
//import com.proway.projeto003.database.dao.DoctorDao
//import com.proway.projeto003.model.Doctor
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//@SmallTest
//class DoctorDaoTest {
//
//    private lateinit var database: AppDatabase
//    private lateinit var dao: DoctorDao
//
//    @Before
//    fun setup() {
//        database = Room.inMemoryDatabaseBuilder(
//            ApplicationProvider.getApplicationContext(),
//            AppDatabase::class.java
//        ).allowMainThreadQueries().build()
//        dao = database.doctorDao()
//
//    }
//
//    @After
//    fun tearDown() {
//        database.close()
//    }
//
//    @Test
//    fun testing_insert_doctor_should_return_true() {
//        val newDoctor1 = Doctor(name = "José", specialityPK = 1)
//        val newDoctor2 = Doctor(name = "Umberto", specialityPK = 2)
//        val newDoctor3 = Doctor(name = "Maria", specialityPK = 1)
//        val listToInsert = arrayListOf(newDoctor1, newDoctor2, newDoctor3)
//        dao.insert(listToInsert)
//
//        val results = dao.getDoctors()
//        assertThat(results).hasSize(listToInsert.size)
//    }
//}