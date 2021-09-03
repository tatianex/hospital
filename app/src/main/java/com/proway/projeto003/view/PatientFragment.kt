package com.proway.projeto003.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto003.R
import com.proway.projeto003.adapter.PatientAdapter
import com.proway.projeto003.databinding.PatientFragmentBinding
import com.proway.projeto003.model.Patient
import com.proway.projeto003.view_model.PatientViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PatientFragment : Fragment(R.layout.patient_fragment) {

    companion object {
        fun newInstance() = PatientFragment()
    }

    private lateinit var viewModel: PatientViewModel
    private lateinit var binding: PatientFragmentBinding
    private var selectedPatient: Patient? = null

    private lateinit var recyclerView: RecyclerView

    private val adapter = PatientAdapter() {
        println(it)
    }

    private val observerPatient = Observer<List<Patient>> {
        adapter.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PatientFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(PatientViewModel::class.java)

        recyclerView = binding.patientsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.patients.observe(viewLifecycleOwner, observerPatient)
        viewModel.getPatients()
        binding.newButton.setOnClickListener {
            val name = binding.nameEditText.text
            val gender = binding.genderEditText.text
            val age = binding.ageEditText.text

            if (name.toString().isNotEmpty() && gender.toString().isNotEmpty() && age.toString().isNotEmpty()) {
                viewModel.insertPatient(Patient(name = name.toString(), gender = toString(), age = age.toString().toInt()))
            }
        }
    }

}