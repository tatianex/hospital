package com.proway.projeto003.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.projeto003.model.Doctor
import com.proway.projeto003.model.DoctorPojo
import com.proway.projeto003.model.Speciality
import com.proway.projeto003.repository.DoctorRepository
import com.proway.projeto003.repository.SpecialityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoctorViewModel @Inject constructor(
    private val doctorRepository: DoctorRepository,
    private val specialityRepository: SpecialityRepository
) : ViewModel() {

    private val _doctors = MutableLiveData<List<DoctorPojo>>()
    val doctors: LiveData<List<DoctorPojo>> = _doctors

    private val _specialities = MutableLiveData<List<Speciality>>()
    val specialities: LiveData<List<Speciality>> = _specialities

    fun getDoctors() {
        _doctors.value = doctorRepository.getDoctors()
    }

    fun insertDoctor(doctor: Doctor) {
        doctorRepository.insert(doctor)
        getDoctors()
    }

    fun updateDoctor(doctor: Doctor) {
        doctorRepository.update(doctor)
        getDoctors()
    }

    fun deleteDoctor(doctor: Doctor) {
        doctorRepository.delete(doctor)
        getDoctors()
    }

    fun getSpeciality() {
        _specialities.value = specialityRepository.getSpecialities()
    }
}