package com.proway.crudizin_basico.view

import androidx.fragment.app.Fragment
import com.proway.crudizin_basico.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PatientFragment : Fragment(R.layout.fragment_patient) {

    companion object {
        fun newInstance() = PatientFragment()
    }


}