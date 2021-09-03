package com.proway.projeto003.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Speciality (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "speciality_id")
    val id: Int = 0,
    @ColumnInfo(name = "speciality_name")
    val name: String
)
