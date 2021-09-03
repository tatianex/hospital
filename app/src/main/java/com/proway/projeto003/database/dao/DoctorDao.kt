package com.proway.projeto003.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.proway.projeto003.model.Doctor
import com.proway.projeto003.model.DoctorPojo

@Dao
interface DoctorDao {

    @Transaction
    @Query("SELECT * FROM Doctor")
    fun getDoctors(): List<DoctorPojo>

    @Transaction
    @Query("SELECT * FROM Doctor WHERE doctor_id = :id")
    fun getDoctorById(id: Int): DoctorPojo

    @Transaction
    @Query("SELECT * FROM Doctor WHERE doctor_name LIKE '%' || :name || '%'")
    fun getDoctorByName(name: String): List<DoctorPojo>

    @Insert
    fun insert(doctor: Doctor)

    @Delete
    fun delete(doctor: Doctor)

    @Update
    fun update(doctor: Doctor)

    @Insert(onConflict = ABORT)
    fun insert(list: List<Doctor>)

}