package com.example.roomdbwithdiffutils.roomdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StudentViewModel(private val respositry: StRespositry) : ViewModel() {
    val allStudents : LiveData<List<StInfoEntity>> = respositry.allStudents
    fun insert(studentinfo: StInfoEntity) = viewModelScope.launch {
        respositry.insertStudent(studentinfo)
    }

    fun delete(studentinfo: StInfoEntity) = viewModelScope.launch {
        respositry.deleteStudent(
            studentinfo
        )
    }

    fun update(studentinfo: StInfoEntity) = viewModelScope.launch {
        respositry.upDateStudent(studentinfo)
    }

}