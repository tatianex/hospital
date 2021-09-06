package com.proway.projeto003.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto003.R
import com.proway.projeto003.databinding.SpecialityItemLayoutBinding
import com.proway.projeto003.model.Speciality

class SpecialityAdapter(val onTap: (Speciality) -> Unit): RecyclerView.Adapter<SpecialityViewHolder>() {

    private var listOfSpecialities = mutableListOf<Speciality>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialityViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.speciality_item_layout, parent, false).let {
                SpecialityViewHolder(it, onTap)
            }
    }

    override fun onBindViewHolder(holder: SpecialityViewHolder, position: Int) {
        listOfSpecialities[position].let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = listOfSpecialities.size

    fun update(newList: List<Speciality>) {
        listOfSpecialities = mutableListOf()
        listOfSpecialities.addAll(newList)
        notifyDataSetChanged()
    }

}

class SpecialityViewHolder(itemView: View, val onTap: (Speciality) -> Unit) : RecyclerView.ViewHolder(itemView) {

    private val binding = SpecialityItemLayoutBinding.bind(itemView)

    fun bind (speciality: Speciality) {
        binding.idTextView.text = speciality.id.toString()
        binding.nameTextView.text = speciality.name
        itemView.setOnClickListener { onTap(speciality) }
    }
}