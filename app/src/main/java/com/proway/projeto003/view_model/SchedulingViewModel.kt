//package com.proway.projeto003.view_model
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.proway.projeto003.model.DoctorPojo
//import com.proway.projeto003.model.SchedulingPOJO
//import com.proway.projeto003.repository.DoctorRepository
//import com.proway.projeto003.repository.SchedulingRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import javax.inject.Inject
//
//@HiltViewModel
//class SchedulingViewModel @Inject constructor(
//    private val schedulingRepository: SchedulingRepository,
//    private val doctorRepository: DoctorRepository
//) : ViewModel() {
//
//    private val _scheduling = MutableLiveData<List<SchedulingPOJO>>()
//    val scheduling: LiveData<List<SchedulingPOJO>> = _scheduling
//
//    private val _doctors = MutableLiveData<List<DoctorPojo>>()
//    val doctors: LiveData<List<DoctorPojo>> = _doctors
//
//    fun getScheduling() {
//        _scheduling.value = schedulingRepository.getScheduling()
//    }
//
//    fun getDoctors() {
//        _doctors.value = doctorRepository.getDoctors()
//    }
//
//    fun filterByPatientGender(patientGender: String) {
//        _scheduling.value = schedulingRepository.selectPatientByGender(patientGender)
//    }
//
//    fun filteByDoctorSpeciality(doctorSpeciality: String) {
//        _scheduling.value = schedulingRepository.selectByDoctorSpeciality(doctorSpeciality)
//    }
//}