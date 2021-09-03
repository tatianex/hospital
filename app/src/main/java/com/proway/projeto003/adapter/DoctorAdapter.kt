package com.proway.projeto003.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto003.R
import com.proway.projeto003.databinding.DoctorItemLayoutBinding
import com.proway.projeto003.model.Doctor

class DoctorAdapter(private val onTap: (Doctor) -> Unit) : RecyclerView.Adapter<DoctorAdapterViewHolder>() {

    private var listOfDoctors = mutableListOf<Doctor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorAdapterViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.doctor_item_layout, parent, false).let {
                DoctorAdapterViewHolder(it, onTap)
            }
    }

    override fun onBindViewHolder(holder: DoctorAdapterViewHolder, position: Int) {
        listOfDoctors[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = listOfDoctors.size

    fun update(newList: List<Doctor>) {
        listOfDoctors = mutableListOf()
        listOfDoctors.addAll(newList)
        notifyDataSetChanged()
    }

}

class DoctorAdapterViewHolder(itemView: View, val onTap: (Doctor) -> Unit): RecyclerView.ViewHolder(itemView) {

    private val binding = DoctorItemLayoutBinding.bind(itemView)

    fun bind(doctor: Doctor) {
        binding.nameTextView.text = doctor.name
        binding.specialityTextView.text = doctor.specialityPK.toString()
    }

}