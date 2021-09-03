package com.proway.projeto003.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.projeto003.model.Patient
import com.proway.projeto003.repository.PatientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PatientViewModel @Inject constructor( private val repository: PatientRepository) : ViewModel() {

    private val _patients = MutableLiveData<List<Patient>>()
    val patients: LiveData<List<Patient>> = _patients

    fun getPatients() {
        _patients.value = repository.getPatients()
    }

    fun insertPatient(patient: Patient) {
        repository.insert(patient)
        getPatients()
    }

    fun updatePatient(patient: Patient) {
        repository.update(patient)
        getPatients()
    }

    fun deletePatient(patient: Patient) {
        repository.delete(patient)
        getPatients()
    }
}