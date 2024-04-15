package com.example.roomdbwithdiffutils.ui.studentprofile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentProViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Student Profile"
    }
    val text: LiveData<String> = _text
}