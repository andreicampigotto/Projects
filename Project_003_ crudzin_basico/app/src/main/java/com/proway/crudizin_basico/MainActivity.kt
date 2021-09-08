package com.proway.crudizin_basico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.proway.crudizin_basico.databinding.MainActivityBinding
import com.proway.crudizin_basico.model.Patient
import com.proway.crudizin_basico.view.MainFragment

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
                    //replaceFrag(Patient.newInstance())
                }
                R.id.speciality -> {
                    //replaceFragment(.newInstance())
                }
                R.id.doctor -> {
                    //replaceFragment(.newInstance())
                }

                R.id.agenda -> {
                    //replaceFragment(.newInstance())
                }
            }
            true
        }
    }

    private fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}