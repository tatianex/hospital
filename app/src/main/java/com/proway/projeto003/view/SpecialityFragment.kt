package com.proway.projeto003.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto003.R
import com.proway.projeto003.adapter.SpecialityAdapter
import com.proway.projeto003.databinding.SpecialityFragmentBinding
import com.proway.projeto003.model.Speciality
import com.proway.projeto003.view_model.SpecialityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpecialityFragment : Fragment(R.layout.speciality_fragment) {

    companion object {
        fun newInstance() = SpecialityFragment()
    }

    private lateinit var viewModel: SpecialityViewModel
    private lateinit var binding: SpecialityFragmentBinding
    private var selectedSpeciality: Speciality? = null
    private lateinit var recyclerView: RecyclerView

    private var adapter = SpecialityAdapter() {
        selectedSpeciality = it
        binding.newButton.visibility = GONE
        binding.nameEditText.setText(it.name)
    }

    private val observeSpeciality = Observer<List<Speciality>> {
        adapter.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SpecialityFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(SpecialityViewModel::class.java)

        viewModel.specialities.observe(viewLifecycleOwner, observeSpeciality)
        viewModel.getSpecialities()
        settingRecyclerView()
        createNewSpeciality()
        editSpeciality()
        deleteSpeciality()
    }

    private fun createNewSpeciality() {
        binding.newButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()

            if (name.isNotEmpty()) {
                viewModel.insertSpeciality(
                    Speciality(name = name)
                )
                clearAllFields()
            }
        }
    }

    private fun deleteSpeciality() {
        binding.deleteButton.setOnClickListener {
            selectedSpeciality?.let {
                viewModel.deleteSpeciality(it)
                clearAllFields()
            }
        }
    }

    private fun editSpeciality() {
        binding.editButton.setOnClickListener {
            selectedSpeciality?.let {
                val name = binding.nameEditText

                if (name.editableText.isNotEmpty()) {
                    viewModel.updateSpeciality(
                        Speciality(
                            name = name.text.toString(),
                            id = selectedSpeciality!!.id
                        )
                    )
                    clearAllFields()
                }
            }
        }
    }

    private fun clearAllFields() {
        binding.nameEditText.setText("")
        binding.newButton.visibility = VISIBLE
    }

    private fun settingRecyclerView() {
        recyclerView = binding.specialityRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}