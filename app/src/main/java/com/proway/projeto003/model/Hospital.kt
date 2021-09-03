package com.proway.projeto003.model

import androidx.room.*

@Entity
data class Patient (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "patient_id")
    val id: Int = 0,
    @ColumnInfo(name = "patient_name")
    val name: String,
    @ColumnInfo(name = "patient_age")
    val age: Int,
    @ColumnInfo(name = "patient_gender")
    val gender: String,
    //@ColumnInfo(name = "doctor_id")
    //val doctorFK: Doctor
)

////@Entity
//data class Doctor (
//
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "doctor_id")
//    val id: Int = 0,
//    @ColumnInfo(name = "doctor_name")
//    val name: String,
//    @ColumnInfo(name = "doctor_speciality")
//    val speciality: Speciality
//)
//
////@Entity
//data class Speciality (
//
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "speciality_id")
//    val id: Int = 0,
//    @ColumnInfo(name = "speciality_name")
//    val name: String
//)
//
//data class PatientWithDoctor (
//
//    @Embedded
//    val patient: Patient?,
//    @Relation(
//        parentColumn = "doctor_id",
//        entityColumn = "doctor_id"
//    )
//    val doctor: Doctor?
//)