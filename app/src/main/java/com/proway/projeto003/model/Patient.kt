package com.proway.projeto003.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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
)