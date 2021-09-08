package com.proway.crudizin_nada_basico.view

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.proway.crudizin_nada_basico.R
import com.proway.crudizin_nada_basico.adapter.PatientAdapter
import com.proway.crudizin_nada_basico.databinding.FragmentPatientBinding
import com.proway.crudizin_nada_basico.model.Patient
import com.proway.crudizin_nada_basico.view_model.PatientViewModel
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
        binding.bottomNew.visibility = GONE
        setValueToFields(it)
    }

    private fun setValueToFields(patient: Patient) {
        binding.textInputName.editText?.setText(patient.name_patient)
        binding.textFieldGender.editText?.setText(patient.gender)
        binding.textFieldAge?.editText?.setText(patient.age.toString())
    }

    private val observerPatient = Observer<List<Patient>> {
        adapter.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PatientViewModel::class.java)
        binding = FragmentPatientBinding.bind(view)
        viewModel.patient.observe(viewLifecycleOwner, observerPatient)
        viewModel.getAllPatient()
        settingRecyclerView()
        settingForm()
    }

    private fun settingForm() {
        binding.bottomNew.setOnClickListener {
            val name = binding.textInputName.editText
            val age = binding.textFieldAge.editText
            val gender = binding.textFieldGender.editText

            if (name?.text?.isNotEmpty()!! && age?.text.toString()
                    .isNotEmpty()!! && gender?.text.toString()!!.isNotEmpty()
            ) {
                viewModel.insertPatient(
                    Patient(
                        name_patient = name.text.toString(),
                        age = age?.text.toString().toInt(),
                        gender = gender?.text.toString()
                    )
                )
                clearFields()
            }

            binding.bottomDelete.setOnClickListener {
                selectedPatient?.let {
                    viewModel.deletePatient(it)
                    clearFields()
                }
            }

            binding.bottomEdit.setOnClickListener {
                selectedPatient?.let {

                    val name = binding.textInputName.editText
                    val age = binding.textFieldAge.editText
                    val gender = binding.textFieldGender.editText

                    if (name?.text?.isNotEmpty()!! && age?.text.toString()
                            .isNotEmpty()!! && gender?.text.toString()!!.isNotEmpty()
                    ) {
                        viewModel.updatePatient(
                            Patient(
                                pat_id = selectedPatient!!.pat_id,
                                name_patient = name.text.toString(),
                                age = age?.text.toString().toInt(),
                                gender = gender?.text.toString()
                            )
                        )
                        clearFields()
                    }
                }
            }
        }
    }

    private fun clearFields() {
        binding.textInputName.editText?.setText("")
        binding.textFieldAge.editText?.setText("")
        binding.textFieldGender.editText?.setText("")
        binding.bottomNew.visibility = VISIBLE
    }

    private fun settingRecyclerView() {
        binding.recyclerViewPatient.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerViewPatient.adapter = adapter
    }

}