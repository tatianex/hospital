//package com.proway.projeto003.repository
//
//import com.proway.projeto003.database.dao.SchedulingDao
//import com.proway.projeto003.model.Scheduling
//import com.proway.projeto003.model.SchedulingPOJO
//import javax.inject.Inject
//
//class SchedulingRepository @Inject constructor(private val schedulingDao: SchedulingDao) {
//
//    fun getScheduling(): List<SchedulingPOJO> {
//        return schedulingDao.getScheduling()
//    }
//
//    fun insert(scheduling: Scheduling) {
//        return schedulingDao.insert(scheduling)
//    }
//
//    fun update(scheduling: Scheduling) {
//        return schedulingDao.update(scheduling)
//    }
//
//    fun delete(scheduling: Scheduling) {
//        return schedulingDao.delete(scheduling)
//    }
//
//    fun selectPatientByGender(patientGender: String): List<SchedulingPOJO> {
//        return schedulingDao.getByGender(patientGender)
//    }
//
//    fun selectByDoctorSpeciality(doctorSpeciality: String): List<SchedulingPOJO> {
//        return schedulingDao.getSchedulingByDoctorName(doctorSpeciality)
//    }
//
//}