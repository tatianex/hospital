//package com.proway.projeto003.database.dao
//
//import androidx.room.*
//import com.proway.projeto003.model.Speciality
//Speciality
////@Dao
//interface SpecialityDao {
//
//    @Transaction
//    @Query("SELECT * FROM Speciality")
//    fun getSpecialities(): List<Speciality>
//
//    @Transaction
//    @Query("SELECT * FROM Speciality WHERE speciality_id = :id")
//    fun getById(id: Long): Speciality
//
//    @Insert
//    fun insert(speciality: ArrayList<Speciality>)
//
//    @Delete
//    fun delete(speciality: Speciality)
//
//    @Update
//    fun update(speciality: Speciality)
//}