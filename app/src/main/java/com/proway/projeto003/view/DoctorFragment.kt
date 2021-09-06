package com.proway.projeto003.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto003.R
import com.proway.projeto003.adapter.DoctorAdapter
import com.proway.projeto003.databinding.DoctorFragmentBinding
import com.proway.projeto003.model.Doctor
import com.proway.projeto003.view_model.DoctorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoctorFragment : Fragment(R.layout.doctor_fragment) {

    companion object {
        fun newInstance() = DoctorFragment()
    }

    private lateinit var viewModel: DoctorViewModel
    private lateinit var binding: DoctorFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private var selectedDoctor: Doctor? = null


    private val adapter = DoctorAdapter() {

    }

    private val observerDoctor = Observer<List<Doctor>> {
        adapter.update(it)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DoctorFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(DoctorViewModel::class.java)

        recyclerView = binding.doctorsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        //viewModel.doctors.observe(viewLifecycleOwner, observerDoctor)
        viewModel.getDoctors()
        binding.newButton.setOnClickListener {
            val name = binding.nameEditText.text
            val speciality =  binding.specialityEditText.text

            if (name.toString().isNotEmpty() && speciality.isNullOrEmpty()) {
                viewModel.insertDoctor(Doctor(name = name.toString(), specialityPK = speciality.toString().toInt()))
            }
        }
    }
}