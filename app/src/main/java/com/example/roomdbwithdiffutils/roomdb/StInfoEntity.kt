package com.example.roomdbwithdiffutils.roomdb

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "studentInfo")
@Parcelize
data class StInfoEntity(
    @PrimaryKey (autoGenerate = true)
    val stId :Int=0,
    val stName: String,
    val stAge: Int,
    val stClass: String,
    val stAddress: String

):Parcelable