package com.proway.projeto003.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.ABORT
import com.proway.projeto003.model.Patient

@Dao
interface PatientDao {

    @Transaction
    @Query("SELECT * FROM Patient ORDER BY patient_name")
    fun getPatients(): List<Patient>

    @Transaction
    @Query("SELECT * FROM Patient WHERE patient_id = :id")
    fun getPatientById(id: Int): Patient

    @Query("SELECT * FROM Patient WHERE patient_gender = :gender")
    fun getPatientByGender(gender: String): List<Patient>

    @Insert
    fun insert(patient: Patient)

    @Delete
    fun delete(patient: Patient)

    @Update
    fun update(patient: Patient)

    @Insert(onConflict = ABORT)
    fun insert(list: List<Patient>)
}

