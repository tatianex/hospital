//package com.proway.projeto003.view
//
//import androidx.lifecycle.ViewModelProvider
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.proway.projeto003.R
//import com.proway.projeto003.view_model.DoctorViewModel
//
//class DoctorFragment : Fragment(R.layout.doctor_fragment) {
//
//    companion object {
//        fun newInstance() = DoctorFragment()
//    }
//
//    private lateinit var viewModel: DoctorViewModel
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this).get(DoctorViewModel::class.java)
//
//    }
//
//}