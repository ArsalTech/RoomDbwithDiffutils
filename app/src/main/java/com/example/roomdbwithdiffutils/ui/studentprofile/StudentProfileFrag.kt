package com.example.roomdbwithdiffutils.ui.studentprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.roomdbwithdiffutils.databinding.FragmentStprofileBinding

class StudentProfileFrag : Fragment() {

    private var _binding: FragmentStprofileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val studentProViewModel =
            ViewModelProvider(this).get(StudentProViewModel::class.java)

        _binding = FragmentStprofileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.profileTv
        studentProViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}