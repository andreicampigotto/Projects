package com.proway.crudizin_nada_basico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.crudizin_nada_basico.databinding.MainActivityBinding
import com.proway.crudizin_nada_basico.utils.replaceFrag
import com.proway.crudizin_nada_basico.view.*

class MainActivity : AppCompatActivity() {

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
                    replaceFrag(SpecialistFragment.newInstance())
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