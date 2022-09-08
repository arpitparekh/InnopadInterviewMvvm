package com.example.innopadinterviewmvvm.task_one

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name = "name")
    val name : String,
    @ColumnInfo(name = "surName")
    val surName : String,
    @ColumnInfo(name = "email")
    val email : String,
    @ColumnInfo(name = "password")
    val password : String,
    @ColumnInfo(name = "dob")
    val dob : String,
    @ColumnInfo(name = "mobile")
    val mobile : String,
    @ColumnInfo(name = "gender")
    val gender : String,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0

)