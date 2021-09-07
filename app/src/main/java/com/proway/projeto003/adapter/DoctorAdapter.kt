package com.proway.projeto003.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto003.R
import com.proway.projeto003.databinding.DoctorItemLayoutBinding
import com.proway.projeto003.model.Doctor
import com.proway.projeto003.model.DoctorPojo

class DoctorAdapter(private val onTap: (DoctorPojo) -> Unit) : RecyclerView.Adapter<DoctorViewHolder>() {

    private var listOfDoctors = mutableListOf<DoctorPojo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.doctor_item_layout, parent, false).let {
                DoctorViewHolder(it)
            }
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        listOfDoctors[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener {
                onTap(this)
            }
        }
    }

    override fun getItemCount(): Int = listOfDoctors.size

    fun update(newList: List<DoctorPojo>) {
        listOfDoctors = mutableListOf()
        listOfDoctors.addAll(newList)
        notifyDataSetChanged()
    }
}

class DoctorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding = DoctorItemLayoutBinding.bind(itemView)

    fun bind(doctor: DoctorPojo) {
        binding.nameTextView.text = doctor.doctor?.name
        binding.specialityTextView.text = doctor.speciality?.name
    }

}