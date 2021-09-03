package com.proway.projeto003.database.dao

import androidx.room.*
import com.proway.projeto003.model.Patient

@Dao
interface PatientDao {

    @Transaction
    @Query("SELECT * FROM Patient")
    fun getPatients(): List<Patient>

    @Transaction
    @Query("SELECT * FROM Patient WHERE patient_id = :id")
    fun getById(id: Int): Patient

    @Insert
    fun insert(patient: Patient)

    @Delete
    fun delete(patient: Patient)

    @Update
    fun update(patient: Patient)
}

