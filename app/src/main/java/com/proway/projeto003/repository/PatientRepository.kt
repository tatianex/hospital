package com.proway.projeto003.repository

import com.proway.projeto003.database.dao.PatientDao
import com.proway.projeto003.model.Patient
import javax.inject.Inject

class PatientRepository @Inject constructor(private val patientDao : PatientDao) {

    fun insert(patient: Patient) {
        return patientDao.insert(patient)
    }

    fun getPatients(): List<Patient> {
        return patientDao.getPatients()
    }

    fun update(patient: Patient) {
        return patientDao.update(patient)
    }

    fun delete(patient: Patient) {
        return patientDao.delete(patient)
    }
}