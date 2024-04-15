package com.example.roomdbwithdiffutils.adaters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbwithdiffutils.databinding.StudentitemBinding
import com.example.roomdbwithdiffutils.roomdb.StInfoEntity

class StudentAdapter(private val listener: OnItemClickListener) :
    ListAdapter<StInfoEntity, StudentAdapter.StudentViewHolder>(StudentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {

        val binding =
            StudentitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class StudentViewHolder(private val binding: StudentitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val student = getItem(position)
                    listener.onItemClick(student)
                }
            }
        }

        fun bind(student: StInfoEntity) {
            binding.apply {
                studentname.text = student.stName
                studentage.text = student.stAge.toString()
                studentclass.text = student.stClass
                studentaddress.text = student.stAddress
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(student: StInfoEntity)
    }

    class StudentDiffCallback : DiffUtil.ItemCallback<StInfoEntity>() {
        override fun areItemsTheSame(oldItem: StInfoEntity, newItem: StInfoEntity): Boolean {
            return oldItem.stId == newItem.stId
        }

        override fun areContentsTheSame(oldItem: StInfoEntity, newItem: StInfoEntity): Boolean {
            return oldItem == newItem
        }
    }
}