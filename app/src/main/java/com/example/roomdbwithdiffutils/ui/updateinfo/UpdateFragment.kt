package com.example.roomdbwithdiffutils.ui.updateinfo

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.roomdbwithdiffutils.databinding.FragmentUpdateBinding
import com.example.roomdbwithdiffutils.roomdb.StInfoEntity
import com.example.roomdbwithdiffutils.roomdb.StRespositry
import com.example.roomdbwithdiffutils.roomdb.StudentDataBase
import com.example.roomdbwithdiffutils.roomdb.StudentViewModel
import com.example.roomdbwithdiffutils.roomdb.StudentViewModelFactory

class UpdateFragment : Fragment() {

    val args: UpdateFragmentArgs by navArgs()
    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!

    val database by lazy { StudentDataBase.getDatabase(requireContext()) }
    val repository by lazy { StRespositry(database.studentInfoDao()) }
    lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        studentViewModel = ViewModelProvider(this, StudentViewModelFactory(repository))
            .get(StudentViewModel::class.java)
        binding.stname.text = args.update.stName.toEditable()
        binding.staddress.text = args.update.stAddress.toEditable()
        binding.stclass.text = args.update.stClass.toEditable()
        binding.stage.text = args.update.stAge.toString().toEditable()
        binding.update.setOnClickListener {
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
                    stId = args.update.stId,
                    stName = binding.stname.text.toString(),
                    stAge = binding.stage.text.toString().toIntOrNull() ?: 0,
                    stClass = binding.stclass.text.toString(),
                    stAddress = binding.staddress.text.toString()
                )
                studentViewModel.update(studentInfo)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)


}