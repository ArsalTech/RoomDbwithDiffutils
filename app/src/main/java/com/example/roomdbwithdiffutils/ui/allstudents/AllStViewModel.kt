package com.example.roomdbwithdiffutils.ui.allstudents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllStViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "All Students List"
    }
    val text: LiveData<String> = _text
}