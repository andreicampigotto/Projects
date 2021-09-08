package com.proway.crudizin_basico.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.proway.crudizin_basico.R
import com.proway.crudizin_basico.adapter.PatientAdapter
import com.proway.crudizin_basico.databinding.FragmentPatientBinding
import com.proway.crudizin_basico.model.Patient
import com.proway.crudizin_basico.view_model.PatientViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PatientFragment : Fragment(R.layout.fragment_patient) {

    private lateinit var binding: FragmentPatientBinding

    companion object {
        fun newInstance() = PatientFragment()
    }

    private lateinit var viewModel: PatientViewModel
    private var selectedPatient: Patient? = null

    private val adapter = PatientAdapter {
        selectedPatient = it
    }

    private val observerPatient = Observer<List<Patient>> {
        adapter.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PatientViewModel::class.java)
        binding = FragmentPatientBinding.bind(view)

        binding.recyclerViewPatient.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPatient.adapter = adapter

        viewModel.patient.observe(viewLifecycleOwner, observerPatient)
        viewModel.getAllPatient()

    }
}