package com.proway.crudizin_basico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.proway.crudizin_basico.databinding.MainActivityBinding
import com.proway.crudizin_basico.model.Patient
import com.proway.crudizin_basico.utils.replaceFrag
import com.proway.crudizin_basico.view.DoctorFragment
import com.proway.crudizin_basico.view.MainFragment
import com.proway.crudizin_basico.view.PatientFragment
import com.proway.crudizin_basico.view.SpecialityFragment

class MainActivity : AppCompatActivity(R.layout.main_activity) {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)
        bottomBar()
    }

    private fun bottomBar() {
        binding.bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.patient -> {
                    replaceFrag(PatientFragment.newInstance())
                }
                R.id.speciality -> {
                    replaceFrag(SpecialityFragment.newInstance())
                }
                R.id.doctor -> {
                    replaceFrag(DoctorFragment.newInstance())
                }

                R.id.agenda -> {
                    //replaceFrag(.newInstance())
                }
            }
            true
        }
    }


}