//package com.proway.projeto003.repository
//
//import com.proway.projeto003.database.AppDatabase
//import com.proway.projeto003.database.dao.SpecialityDao
//import com.proway.projeto003.model.Speciality
//import javax.inject.Inject
//
//class SpecialityRepository @Inject constructor(private val specialityDao : SpecialityDao) {
//
//    fun insert(speciality: Speciality) {
//        return specialityDao.insert(arrayListOf(speciality))
//    }
//
//    fun getSpecialities(): List<Speciality> {
//        return specialityDao.getSpecialities()
//    }
//
//    fun update(speciality: Speciality) {
//        return specialityDao.update(speciality)
//    }
//
//    fun delete(speciality: Speciality) {
//        return specialityDao.delete(speciality)
//    }
//}