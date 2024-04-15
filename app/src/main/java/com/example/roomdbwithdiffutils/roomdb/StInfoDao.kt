package com.example.roomdbwithdiffutils.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface StInfoDao {
    @Query("Select * from studentInfo ORDER BY stId ASC")
    fun getAllStInfo():LiveData<List<StInfoEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStInfo(stInfoEntity: StInfoEntity)

    @Update
    suspend fun updateStInfo(stInfoEntity: StInfoEntity)

    @Delete
    suspend fun deleteStInfo(stInfoEntity: StInfoEntity)
}