package com.example.roomdbwithdiffutils

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdbwithdiffutils.adaters.StudentAdapter
import com.example.roomdbwithdiffutils.databinding.ActivityMainBinding
import com.example.roomdbwithdiffutils.roomdb.StInfoEntity
import com.example.roomdbwithdiffutils.roomdb.StRespositry
import com.example.roomdbwithdiffutils.roomdb.StudentDataBase
import com.example.roomdbwithdiffutils.roomdb.StudentViewModel
import com.example.roomdbwithdiffutils.roomdb.StudentViewModelFactory

class MainActivity : AppCompatActivity() , StudentAdapter.OnItemClickListener{
val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
     lateinit var studentViewModel: StudentViewModel
     var age =20;
    private lateinit var adapter: StudentAdapter
    val database by lazy { StudentDataBase.getDatabase(this) }
    val repository by lazy { StRespositry(database.studentInfoDao()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        adapter = StudentAdapter(this)
        binding.recyclerviewstudentinfo.layoutManager = LinearLayoutManager(this)
        binding.recyclerviewstudentinfo.adapter = adapter

        studentViewModel = ViewModelProvider(this, StudentViewModelFactory(repository))
            .get(StudentViewModel::class.java)

        studentViewModel.allStudents.observe(this, Observer { students ->
            students?.let {
               adapter.submitList(it)
                Log.d("data", "onObserve: ${it.toString()}")
            }
        })
        binding.insertrecord.setOnClickListener {
            val studentInfo = StInfoEntity(stName = "John", stAge = age++, stClass = "12th", stAddress = "123 Main St")
            studentViewModel.insert(studentInfo)
        }

        // Example of inserting a student (you can replace this with your actual data insertion logic)

    }

    override fun onItemClick(student: StInfoEntity) {
        Log.d("data", "onItemClick: ")
        val studentInfo = StInfoEntity(stId = student.stId, stName = "John Sena", stAge = age++, stClass = "10th", stAddress = "Gulbahar Main St")

        studentViewModel.update(studentInfo)
    }
}