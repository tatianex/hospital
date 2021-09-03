package com.proway.projeto003.model

import androidx.room.*

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
        parentColumn = "specialityPk",
        entityColumn = "speciality_id"
    )
    val speciality: Speciality?
)