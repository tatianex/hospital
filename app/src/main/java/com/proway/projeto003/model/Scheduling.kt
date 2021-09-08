//package com.proway.projeto003.model
//
//import androidx.room.*
//
//@Entity
//data class Scheduling (
//
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "schedule_id")
//    var id: Int = 0,
//    var patientFK: Int,
//    val doctorFK: Int
//)
//
//data class SchedulingPOJO(
//
//    @Embedded
//    val scheduling: Scheduling,
//
//    @Relation(
//        parentColumn = "patientFK",
//        entityColumn = "patient_id"
//    )
//    val patient: Patient,
//
//    @Relation(
//        parentColumn = "doctorFK",
//        entityColumn = "doctor_id"
//    )
//    val doctor: Doctor
//)