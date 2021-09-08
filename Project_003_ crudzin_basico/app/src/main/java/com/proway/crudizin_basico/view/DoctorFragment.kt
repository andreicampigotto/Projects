package com.proway.crudizin_basico.view

import androidx.fragment.app.Fragment
import com.proway.crudizin_basico.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoctorFragment : Fragment(R.layout.fragment_doctor) {
    
    companion object {
        fun newInstance() = DoctorFragment()
    }

}