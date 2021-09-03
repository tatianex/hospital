package com.proway.projeto003.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.proway.projeto003.database.dao.DoctorDao

import com.proway.projeto003.database.dao.PatientDao
import com.proway.projeto003.database.dao.SpecialityDao

import com.proway.projeto003.model.Patient


@Database(
    entities = [Patient::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun patientDao(): PatientDao
    abstract fun specialityDao(): SpecialityDao
    abstract fun doctorDao(): DoctorDao

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