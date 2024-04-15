package com.example.roomdbwithdiffutils.stateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StateViewModel : ViewModel() {
    private val _state = MutableStateFlow("state ")
    val state : StateFlow<String> = _state.asStateFlow()

    fun updateState(newState : String){
        _state.value = newState
    }
init {
    emitNewValues()
}
    private fun emitNewValues() {
        viewModelScope.launch {
            // Simulate emitting new values every second
            var count = 0
            while (true) {
                delay(1000) // Delay for 1 second
                count++

                updateState("state $count")
            }
        }
    }
}