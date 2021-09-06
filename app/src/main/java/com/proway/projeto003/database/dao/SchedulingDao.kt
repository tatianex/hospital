//package com.proway.projeto003.database.dao
//
//import androidx.room.*
//import androidx.room.OnConflictStrategy.ABORT
//import com.proway.projeto003.model.Scheduling
//import com.proway.projeto003.model.SchedulingPOJO
//
//@Dao
//interface SchedulingDao {
//
//    @Transaction
//    @Query("SELECT * FROM Scheduling s, Doctor d WHERE s.doctorFK = d.doctor_id ORDER BY d.doctor_name")
//    fun getScheduling(): List<SchedulingPOJO>
//
//    @Transaction
//    @Query("SELECT * FROM Scheduling WHERE schedule_id = :id")
//    fun getSchedulingById(id: Int): SchedulingPOJO
//
//    @Transaction
//    @Query("SELECT * FROM Scheduling INNER JOIN Doctor on Doctor.doctor_id = doctorFK WHERE doctor.doctor_name LIKE '%' || :name || '%'")
//    fun getSchedulingByDoctorName(name: String): List<SchedulingPOJO>
//
//    @Transaction
//    @Query("SELECT * FROM Scheduling INNER JOIN Doctor on doctor.doctor_name = doctorFK WHERE doctor.doctor_speciality in (:ids)")
//    fun getSchedulingByDoctorSpeciality(ids: List<Int>): List<SchedulingPOJO>
//
//    @Transaction
//    @Query("SELECT * FROM Scheduling INNER JOIN Patient on patient.patient_id = patient.patient_id = patientFK WHERE patient_name LIKE '%' || :name || '%'")
//    fun getByPatientName(name: String): List<SchedulingPOJO>
//
//    @Transaction
//    @Query("SELECT * FROM Scheduling INNER JOIN Patient on patient.patient_id = patientFK WHERE patient_gender = :gender")
//    fun getByGender(gender: String): List<SchedulingPOJO>
//
//    @Delete
//    fun delete(scheduling: Scheduling)
//
//    @Update
//    fun update(scheduling: Scheduling)
//
//    @Insert(onConflict = ABORT)
//    fun insert(list: List<Scheduling>)
//}