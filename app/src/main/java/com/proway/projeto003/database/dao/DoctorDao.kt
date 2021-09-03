//package com.proway.projeto003.database.dao
//
//import androidx.room.*
//import com.proway.projeto003.model.Doctor
//
////@Dao
//interface DoctorDao {
//
//    @Transaction
//    @Query("SELECT * FROM Doctor")
//    fun getDoctors(): List<Doctor>
//
//    @Transaction
//    @Query("SELECT * FROM Doctor WHERE doctor_id = :id")
//    fun getById(id: Int): Doctor
//
//    @Insert
//    fun insert(doctor: Doctor)
//
//    @Delete
//    fun delete(doctor: Doctor)
//
//    @Update
//    fun update(doctor: Doctor)
//
//}