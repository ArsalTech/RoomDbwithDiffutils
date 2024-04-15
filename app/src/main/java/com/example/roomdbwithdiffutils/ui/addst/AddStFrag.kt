package com.example.roomdbwithdiffutils.ui.addst

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.roomdbwithdiffutils.adaters.StudentAdapter
import com.example.roomdbwithdiffutils.databinding.FragmentAddstuBinding
import com.example.roomdbwithdiffutils.roomdb.StInfoEntity
import com.example.roomdbwithdiffutils.roomdb.StRespositry
import com.example.roomdbwithdiffutils.roomdb.StudentDataBase
import com.example.roomdbwithdiffutils.roomdb.StudentViewModel
import com.example.roomdbwithdiffutils.roomdb.StudentViewModelFactory

class AddStFrag : Fragment() {

    private var _binding: FragmentAddstuBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var studentViewModel: StudentViewModel
    val database by lazy { StudentDataBase.getDatabase(requireContext()) }
    val repository by lazy { StRespositry(database.studentInfoDao()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val addViewModel =
//            ViewModelProvider(this).get(AddViewModel::class.java)

       _binding = FragmentAddstuBinding.inflate(inflater, container, false)
       val root: View = binding.root
//
//        val textView: TextView = binding.addupdateTv
//        addViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        studentViewModel = ViewModelProvider(this, StudentViewModelFactory(repository))
            .get(StudentViewModel::class.java)
        binding.submit.setOnClickListener {
            if (TextUtils.isEmpty(binding.stname.text)) {
                binding.stname.error = "enter name"
            } else if (TextUtils.isEmpty(binding.stage.text)) {
                binding.stage.error = "enter age"
            } else if (TextUtils.isEmpty(binding.staddress.text)) {
                binding.staddress.error = "enter address"
            } else if (TextUtils.isEmpty(binding.stclass.text)) {
                binding.stclass.error = "enter class"
            } else {

                val studentInfo = StInfoEntity(
                    stName = binding.stname.text.toString(),
                    stAge = binding.stage.text.toString().toIntOrNull() ?: 0,
                    stClass = binding.stclass.text.toString(),
                    stAddress = binding.staddress.text.toString()
                )
                studentViewModel.insert(studentInfo)


            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

}