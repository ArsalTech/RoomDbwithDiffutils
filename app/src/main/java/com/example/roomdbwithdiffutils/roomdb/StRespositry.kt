package com.example.roomdbwithdiffutils.roomdb

import androidx.lifecycle.LiveData

class StRespositry(private val stDao: StInfoDao) {
    val allStudents : LiveData<List<StInfoEntity>> = stDao.getAllStInfo()
    suspend fun insertStudent(studentInfo : StInfoEntity){
        stDao.insertStInfo(studentInfo)
    }
    suspend fun upDateStudent(studentInfo : StInfoEntity){
        stDao.updateStInfo(studentInfo)
    }
    suspend fun deleteStudent(studentInfo : StInfoEntity){
        stDao.deleteStInfo(studentInfo)
    }
}