//package com.proway.projeto003.view
//
//import android.content.Intent
//import androidx.lifecycle.ViewModelProvider
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.View
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.proway.projeto003.R
//import com.proway.projeto003.adapter.SchedulingAdapter
//import com.proway.projeto003.databinding.SchedulingFragmentBinding
//import com.proway.projeto003.model.DoctorPojo
//import com.proway.projeto003.model.Patient
//import com.proway.projeto003.view_model.SchedulingViewModel
//
//class SchedulingFragment : Fragment(R.layout.scheduling_fragment) {
//
//    companion object {
//        fun newInstance() = SchedulingFragment()
//    }
//
//    private lateinit var viewModel: SchedulingViewModel
//    private lateinit var binding: SchedulingFragmentBinding
//    private var electedDoctorPojo: DoctorPojo? = null
//    private var listOfPatients: List<Patient> = null
//    private var selectedPatient: Patient? = null
//    private var listOfDoctors: List<DoctorPojo>? = null
//    private var adapter = SchedulingAdapter(this)
//
//
//    private val observerScheduling = Observer<List<SchedulingPojo>> { schedulingList ->
//        adapter.update(schedulingList)
//    }
//
//    private val observePatients = Observer<List<Patient>> { patients ->
//        listOfPatients = patients
//        autoCompleteFields(listOfPatients!!)
//    }
//
//    private val observeDoctors = Observer<List<DoctorPojo>> { doctorWithSpeciality ->
//        listOfDoctors = doctorWithSpeciality
//        autoCompleteFields(listOfDoctors!!)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = SchedulingFragmentBinding.bind(view)
//        viewModel = ViewModelProvider(this).get(SchedulingViewModel::class.java)
//
//        binding.recyclerViewScheduling.layoutManager = LinearLayoutManager(requireContext())
//        binding.recyclerViewScheduling.adapter = adapter
//
//
//
//    }
//
//}