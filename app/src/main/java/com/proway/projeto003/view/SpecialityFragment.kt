package com.proway.projeto003.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.projeto003.R
import com.proway.projeto003.adapter.SpecialityAdapter
import com.proway.projeto003.databinding.SpecialityFragmentBinding
import com.proway.projeto003.model.Speciality
import com.proway.projeto003.view_model.SpecialityViewModel

class SpecialityFragment : Fragment(R.layout.speciality_fragment) {

    companion object {
        fun newInstance() = SpecialityFragment()
    }

    private lateinit var viewModel: SpecialityViewModel
    private lateinit var binding: SpecialityFragmentBinding
    private var selectedSpeciality: Speciality? = null
    private lateinit var recyclerView: RecyclerView

    private var adapter = SpecialityAdapter() {

    }

    private val observeSpeciality = Observer<List<Speciality>> {
        adapter.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SpecialityFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(SpecialityViewModel::class.java)

        recyclerView = binding.specialityRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.specialities.observe(viewLifecycleOwner, observeSpeciality)
        viewModel.getSpecialities()
        binding.newButton.setOnClickListener {
            val id = binding.idEditText.text
            val name = binding.nameEditText.text

            if (name.toString().isNotEmpty()) {
                    viewModel.insertSpeciality(Speciality(name = name.toString()))
            }
        }
    }
}