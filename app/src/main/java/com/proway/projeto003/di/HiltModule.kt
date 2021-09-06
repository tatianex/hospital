package com.proway.projeto003.di

import android.content.Context
import com.proway.projeto003.database.AppDatabase
import com.proway.projeto003.database.dao.DoctorDao
import com.proway.projeto003.database.dao.PatientDao
import com.proway.projeto003.database.dao.SpecialityDao
import com.proway.projeto003.repository.DoctorRepository
import com.proway.projeto003.repository.PatientRepository
import com.proway.projeto003.repository.SpecialityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun providerPatientDao(@ApplicationContext context: Context): PatientDao {
        return AppDatabase.getDatabase(context).patientDao()
    }

    @Provides
    fun providerDoctorDao(@ApplicationContext context: Context): DoctorDao {
        return AppDatabase.getDatabase(context).doctorDao()
    }

    @Provides
    fun providerSpecialityDao(@ApplicationContext context: Context): SpecialityDao {
        return AppDatabase.getDatabase(context).specialityDao()
    }

    @Provides
    fun providePatientRepository(dao: PatientDao) = PatientRepository(dao)

    @Provides
    fun provideSpecialityRepository(dao: SpecialityDao) = SpecialityRepository(dao)

    @Provides
    fun provideDoctorRepository(dao: DoctorDao) = DoctorRepository(dao)
}