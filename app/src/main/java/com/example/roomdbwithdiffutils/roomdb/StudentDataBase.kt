package com.example.roomdbwithdiffutils.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [StInfoEntity::class], version = 1)
abstract  class StudentDataBase : RoomDatabase() {
    abstract fun studentInfoDao():StInfoDao
    companion object{
        @Volatile
       private var INSTANCE:StudentDataBase?=null
        fun getDatabase(context:Context):StudentDataBase{
        return INSTANCE?: synchronized(this){
            val intance = Room.databaseBuilder(
                context.applicationContext,
                StudentDataBase::class.java,
                "studentInfoDb"
            ).build()
            INSTANCE = intance
            intance
        }
        }
    }
}