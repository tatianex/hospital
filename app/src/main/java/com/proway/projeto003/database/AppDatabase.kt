package com.proway.projeto003.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proway.projeto003.database.dao.DoctorDao

import com.proway.projeto003.database.dao.PatientDao
import com.proway.projeto003.database.dao.SpecialityDao
import com.proway.projeto003.model.Doctor

import com.proway.projeto003.model.Patient
import com.proway.projeto003.model.Speciality


@Database(
    entities = [Patient::class, Doctor::class, Speciality::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun patientDao(): PatientDao
    abstract fun specialityDao(): SpecialityDao
    abstract fun doctorDao(): DoctorDao
    // abstract fun schedulingDao(): SpecialityDao

    companion object {

        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "hospital_app_db"
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}