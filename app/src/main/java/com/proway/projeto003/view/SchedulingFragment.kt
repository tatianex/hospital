package com.proway.projeto003.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proway.projeto003.R
import com.proway.projeto003.view_model.SchedulingViewModel

class SchedulingFragment : Fragment(R.layout.scheduling_fragment) {

    companion object {
        fun newInstance() = SchedulingFragment()
    }

    private lateinit var viewModel: SchedulingViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SchedulingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}