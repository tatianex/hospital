package com.proway.projeto003.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.projeto003.model.Doctor
import com.proway.projeto003.repository.DoctorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoctorViewModel @Inject constructor(private val repository: DoctorRepository) : ViewModel() {

    private val _doctors = MutableLiveData<List<Doctor>>()
    val doctors: LiveData<List<Doctor>> = _doctors

    fun getDoctors() {
        _doctors.value = repository.getDoctors()
    }

    fun insertDoctor(doctor: Doctor) {
        repository.insert(doctor)
        getDoctors()
    }

    fun updateDoctor(doctor: Doctor) {
        repository.update(doctor)
        getDoctors()
    }

    fun deleteDoctor(doctor: Doctor) {
        repository.delete(doctor)
        getDoctors()
    }
}