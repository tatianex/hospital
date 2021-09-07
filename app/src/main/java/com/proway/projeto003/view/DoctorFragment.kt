package com.proway.projeto003.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto003.R
import com.proway.projeto003.adapter.DoctorAdapter
import com.proway.projeto003.databinding.DoctorFragmentBinding
import com.proway.projeto003.model.Doctor
import com.proway.projeto003.model.DoctorPojo
import com.proway.projeto003.model.Speciality
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
    private lateinit var adapterSpinner: ArrayAdapter<String>
    private var selectedDoctor: DoctorPojo? = null
    private var selectedSpeciality: Speciality? = null

    private val adapter: DoctorAdapter = DoctorAdapter {
        setValuesToFields(it)
    }

    private val observerDoctor = Observer<List<DoctorPojo>> {
        adapter.update(it)
    }

    private val observerSpeciality = Observer<List<Speciality>> {
        val listOfSpecialities = it.map { speciality ->
            speciality.name
        }
        adapterSpinner.addAll(listOfSpecialities)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DoctorFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(DoctorViewModel::class.java)
        startViewModel()
        settingRecyclerView()
        createNewDoctor()
        editDoctor()
        deleteDoctor()
    }

    private fun startViewModel() {
        viewModel.doctors.observe(viewLifecycleOwner, observerDoctor)
        viewModel.specialities.observe(viewLifecycleOwner, observerSpeciality)
        viewModel.getDoctors()
        viewModel.getSpeciality()
    }

    private fun createNewDoctor() {
        binding.newButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            if (name.isNotEmpty() && selectedSpeciality != null) {
                viewModel.insertDoctor(
                    Doctor(
                        name = name,
                        specialityPK = selectedSpeciality!!.id
                    )
                )
                clearAllFields()
            }
        }
    }

    private fun editDoctor() {
        binding.editButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()

            if (name.isNotEmpty() && selectedSpeciality != null) {
                viewModel.updateDoctor(
                    Doctor(
                        name = name,
                        specialityPK = selectedSpeciality!!.id
                    )
                )
                clearAllFields()
            }
        }
    }

    private fun deleteDoctor() {
        binding.deleteButton.setOnClickListener {
            selectedDoctor?.doctor?.let {
                viewModel.deleteDoctor(it)
            }
            clearAllFields()
        }
    }

    private fun setValuesToFields(it: DoctorPojo) {
        binding.nameEditText.setText(it.doctor?.name)
        binding.newButton.visibility = GONE
        selectedDoctor = it
        selectedSpeciality = it.speciality
    }

    private fun clearAllFields() {
        binding.nameEditText.setText("")
        binding.inputSpecialityTextInputLayout.editText?.setText("")
        binding.newButton.visibility = VISIBLE
        selectedSpeciality = null
        selectedDoctor = null
    }

    private fun autoCompleteField() {
        adapterSpinner = ArrayAdapter<String>(requireContext(), R.layout.spinner_item_speciality)
        val autoComplete: AutoCompleteTextView? =
            binding.inputSpecialityTextInputLayout.editText as? AutoCompleteTextView
        autoComplete?.setAdapter(adapterSpinner)
        autoComplete?.setOnItemClickListener { parent, view, position, id ->
            val selected = parent.getItemAtPosition(position) as String
            viewModel.specialities.value?.first { speciality ->
                (speciality.name.equals(selected, true)) }?.let {
                    selectedSpeciality = it
                }
        }
    }

    private fun settingRecyclerView() {
        recyclerView = binding.doctorsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}