package com.example.roomdbwithdiffutils.ui.addst

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Enter Student Info"
    }
    val text: LiveData<String> = _text
}