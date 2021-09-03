package com.proway.projeto003.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto003.R
import com.proway.projeto003.databinding.PatientItemLayoutBinding
import com.proway.projeto003.model.Patient

class PatientAdapter(val onTap: (Patient) -> Unit): RecyclerView.Adapter<PatientViewHolder>() {

    private var listOfPatient = mutableListOf<Patient>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.patient_item_layout, parent, false).let {
                PatientViewHolder(it, onTap)
            }
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        listOfPatient[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = listOfPatient.size

    fun update(newList: List<Patient>) {
        listOfPatient = mutableListOf()
        listOfPatient.addAll(newList)
        notifyDataSetChanged()
    }
}

class PatientViewHolder(itemView: View, val onTap: (Patient) -> Unit): RecyclerView.ViewHolder(itemView) {

    private val binding = PatientItemLayoutBinding.bind(itemView)

    fun bind(patient: Patient) {
        //binding.idTextView.text = patient.id.toString()
        binding.nameTextView.text = patient.name
        //binding.ageTextView.text = patient.age.toString()
        //binding.genderTextView.text = patient.gender
        itemView.setOnClickListener { onTap(patient) }
    }
}
