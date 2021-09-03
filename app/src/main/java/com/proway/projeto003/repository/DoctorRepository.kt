//package com.proway.projeto003.repository
//
//import com.proway.projeto003.database.AppDatabase
//import com.proway.projeto003.database.dao.DoctorDao
//import com.proway.projeto003.model.Doctor
//import com.proway.projeto003.model.PatientWithDoctor
//import javax.inject.Inject
//
//class DoctorRepository @Inject constructor(private val doctorDao: DoctorDao){
//
//
//    fun insert(doctor: Doctor) {
//        return doctorDao.insert(doctor)
//    }
//
//    fun getDoctors(): List<Doctor> {
//        return doctorDao.getDoctors()
//    }
//
//    fun update(doctor: Doctor) {
//        return doctorDao.update(doctor)
//    }
//
//    fun delete(doctor: Doctor) {
//        return doctorDao.delete(doctor)
//    }
//}