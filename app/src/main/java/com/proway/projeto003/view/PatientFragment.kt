package com.proway.projeto003.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
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

    private val adapter = PatientAdapter {
        selectedPatient = it
        binding.newButton.visibility = GONE
        setValueToFields(it)
    }

    private fun setValueToFields(it: Patient) {
        binding.nameEditText.setText(it.name)
        binding.ageEditText.setText(it.age.toString())
        binding.genderEditText.setText(it.gender)
    }

    private val observerPatient = Observer<List<Patient>> {
        adapter.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PatientFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(PatientViewModel::class.java)
        viewModel.patients.observe(viewLifecycleOwner, observerPatient)
        viewModel.getPatients()
        settingRecyclerView()
        createNewPatient()
        deletePatient()
        editPatient()
    }

    private fun createNewPatient() {
        binding.newButton.setOnClickListener {
            val name = binding.nameEditText.text
            val gender = binding.genderEditText.text
            val age = binding.ageEditText.text

            if (name.toString().isNotEmpty() && gender.toString().isNotEmpty() && age.toString().isNotEmpty()) {
                viewModel.insertPatient(
                    Patient(
                        name = name.toString(),
                        gender = gender.toString(),
                        age = age.toString().toInt()
                    )
                )
                clearAllFields()
            }
        }
    }

    private fun deletePatient() {
        binding.deleteButton.setOnClickListener {
            selectedPatient?.let {
                viewModel.deletePatient(it)
                clearAllFields()
            }
        }
    }

    private fun editPatient() {
        binding.editButton.setOnClickListener {
            selectedPatient?.let {
                val name = binding.nameEditText
                val age = binding.ageEditText
                val gender = binding.genderEditText

                if (name.editableText.isNotEmpty() &&
                    age.text.toString().isNotEmpty() &&
                    gender.text.toString().isNotEmpty()
                ) {
                    viewModel.updatePatient(
                        Patient(
                            id = selectedPatient!!.id,
                            name = name.text.toString(),
                            age = age.text.toString().toInt(),
                            gender = gender.text.toString()
                        )
                    )
                    clearAllFields()
                }
            }
        }
    }

    private fun clearAllFields() {
        binding.nameEditText.setText("")
        binding.ageEditText.setText("")
        binding.genderEditText.setText("")
        binding.newButton.visibility = VISIBLE
    }

    private fun settingRecyclerView() {
        recyclerView = binding.patientsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}