package com.example.roomdbwithdiffutils

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.roomdbwithdiffutils.databinding.ActivityMainBinding
import com.example.roomdbwithdiffutils.databinding.ActivityStudentBinding
import com.example.roomdbwithdiffutils.roomdb.StRespositry
import com.example.roomdbwithdiffutils.roomdb.StudentDataBase
import com.example.roomdbwithdiffutils.roomdb.StudentViewModel
import com.example.roomdbwithdiffutils.roomdb.StudentViewModelFactory

class StudentActivity : AppCompatActivity() {

    val binding by lazy { ActivityStudentBinding.inflate(layoutInflater) }

    //    lateinit var studentViewModel: StudentViewModel
//
//    val database by lazy { StudentDataBase.getDatabase(this) }
//
//    val repository by lazy { StRespositry(database.studentInfoDao()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//
//        studentViewModel = ViewModelProvider(this, StudentViewModelFactory(repository))
//            .get(StudentViewModel::class.java)

//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_student)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_allstudents, R.id.navigation_addupdatest, R.id.navigation_stprofile
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }
}