package com.proway.projeto003.di

import android.content.Context
import com.proway.projeto003.database.AppDatabase
import com.proway.projeto003.database.dao.DoctorDao
import com.proway.projeto003.database.dao.PatientDao
import com.proway.projeto003.database.dao.SpecialityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun providerPatientDatabase(@ApplicationContext context: Context): PatientDao {
        return AppDatabase.getDatabase(context).patientDao()
    }

    @Provides
    fun providerDoctorDatabase(@ApplicationContext context: Context): DoctorDao {
        return AppDatabase.getDatabase(context).doctorDao()
    }

    @Provides
    fun providerSpecialityDatabase(@ApplicationContext context: Context): SpecialityDao {
        return AppDatabase.getDatabase(context).specialityDao()
    }
}