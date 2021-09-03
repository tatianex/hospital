//package com.proway.projeto003.view_model
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.proway.projeto003.model.Speciality
//import com.proway.projeto003.repository.SpecialityRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import javax.inject.Inject
//
//@HiltViewModel
//class SpecialityViewModel @Inject constructor(private val repository: SpecialityRepository) : ViewModel() {
//
//    private val _specialities = MutableLiveData<List<Speciality>>()
//    val specialities : LiveData<List<Speciality>> = _specialities
//
//    fun getSpecialities() {
//        _specialities.value = repository.getSpecialities()
//    }
//
//    fun insertSpeciality(speciality: Speciality) {
//        repository.insert(speciality)
//        getSpecialities()
//    }
//
//    fun updateSpeciality(speciality: Speciality) {
//        repository.update(speciality)
//        getSpecialities()
//    }
//
//    fun deleteSpeciality(speciality: Speciality) {
//        repository.delete(speciality)
//        getSpecialities()
//    }
//}