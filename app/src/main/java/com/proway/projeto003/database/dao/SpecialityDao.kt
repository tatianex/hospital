package com.proway.projeto003.database.dao

import androidx.room.*
import com.proway.projeto003.model.Speciality

@Dao
interface SpecialityDao {

    @Transaction
    @Query("SELECT * FROM Speciality ORDER BY speciality_name")
    fun getSpecialities(): List<Speciality>

    @Transaction
    @Query("SELECT * FROM Speciality WHERE speciality_id = :id")
    fun getSpecialityById(id: Int): Speciality

    @Query("SELECT * FROM Speciality WHERE speciality_name like '%' || :name || '%'")
    fun getSpecialityByName(name: String): List<Speciality>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(speciality: ArrayList<Speciality>)

    @Delete
    fun delete(speciality: Speciality)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(speciality: Speciality)

}