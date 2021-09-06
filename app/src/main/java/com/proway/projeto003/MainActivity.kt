package com.proway.projeto003

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.projeto003.databinding.MainActivityBinding
import com.proway.projeto003.utils.replaceFragment
import com.proway.projeto003.view.DoctorFragment
import com.proway.projeto003.view.PatientFragment
import com.proway.projeto003.view.SpecialityFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        settingBottomBar()
        settingInitialFragment()
    }

    fun settingBottomBar() {
        binding.bottomBarNav.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.nav_pacients -> {
                    replaceFragment(fragment = PatientFragment.newInstance())
                }
                R.id.nav_doctors -> {
                    replaceFragment(fragment = DoctorFragment.newInstance())
                }
                R.id.nav_specialities -> {
                    replaceFragment(fragment = SpecialityFragment.newInstance())
                }
//                R.id.nav_appointments -> {
//                    replaceFragment(fragment = SchedulingFragment.newInstance())
//                }
            }
            true
        }
    }

    private fun settingInitialFragment() {
        replaceFragment(PatientFragment.newInstance())
    }

}