package com.example.roomdbwithdiffutils.stateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.roomdbwithdiffutils.R
import com.example.roomdbwithdiffutils.databinding.ActivityMainBinding
import com.example.roomdbwithdiffutils.databinding.ActivityStateflowBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StateFlowMainActivity : AppCompatActivity() {
    val binding by lazy {ActivityStateflowBinding.inflate(layoutInflater) }
    private val stateViewModel : StateViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(binding.root)
        binding.emit.setOnClickListener {
            lifecycleScope.launch {
                stateViewModel.state.collect{
                    Log.d("state", "onCreate: $it")
                }
            }
        }
    }
}