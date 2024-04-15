package com.example.roomdbwithdiffutils.ui.allstudents

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdbwithdiffutils.R
import com.example.roomdbwithdiffutils.adaters.StudentAdapter
import com.example.roomdbwithdiffutils.databinding.FragmentAllstBinding
import com.example.roomdbwithdiffutils.roomdb.StInfoEntity
import com.example.roomdbwithdiffutils.roomdb.StRespositry
import com.example.roomdbwithdiffutils.roomdb.StudentDataBase
import com.example.roomdbwithdiffutils.roomdb.StudentViewModel
import com.example.roomdbwithdiffutils.roomdb.StudentViewModelFactory

class AllStudentsFrag : Fragment(), StudentAdapter.OnItemClickListener {


    private var _binding: FragmentAllstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapter: StudentAdapter
    val database by lazy { StudentDataBase.getDatabase(requireContext()) }
    val repository by lazy { StRespositry(database.studentInfoDao()) }

      lateinit var studentViewModel: StudentViewModel
//    private val studentViewModel: StudentViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllstBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textHome.setOnClickListener { findNavController().navigate(R.id.action_navigation_allstudents_to_navigation_stprofile) }
        binding.addstudent.setOnClickListener {

            findNavController().navigate(R.id.action_navigation_allstudents_to_navigation_addst)
        }
        adapter = StudentAdapter(this)
        binding.rvallstudents.layoutManager = LinearLayoutManager(requireContext())
        binding.rvallstudents.adapter = adapter
        studentViewModel = ViewModelProvider(this, StudentViewModelFactory(repository))
            .get(StudentViewModel::class.java)

        studentViewModel.allStudents.observe(viewLifecycleOwner, Observer { students ->
            students?.let {
                adapter.submitList(it)
                Log.d("data", "onObserve: ${it.toString()}")
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(student: StInfoEntity) {
        val action =
            AllStudentsFragDirections.actionNavigationAllstudentsToUpdatestFragment(student)
        findNavController().navigate(action)
    }
}