package com.proway.projeto003.model

import androidx.room.*
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Doctor (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "doctor_id")
    val id: Int = 0,
    @ColumnInfo(name = "doctor_name")
    val name: String,
    @ColumnInfo(name = "doctor_speciality")
    val specialityPK: Int
)

data class DoctorPojo(

    @Embedded
    val doctor: Doctor?,
    @Relation(
        parentColumn = "doctor_speciality",
        entityColumn = "speciality_id"
    )
    val speciality: Speciality?
)