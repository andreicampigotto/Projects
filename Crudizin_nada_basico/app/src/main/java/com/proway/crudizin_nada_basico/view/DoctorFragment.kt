package com.proway.crudizin_nada_basico.view

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.proway.crudizin_nada_basico.R
import com.proway.crudizin_nada_basico.adapter.DoctorAdapter
import com.proway.crudizin_nada_basico.databinding.FragmentDoctorBinding
import com.proway.crudizin_nada_basico.model.Doctor
import com.proway.crudizin_nada_basico.model.DoctorWithSpeciality
import com.proway.crudizin_nada_basico.model.Speciality
import com.proway.crudizin_nada_basico.view_model.DoctorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoctorFragment : Fragment(R.layout.fragment_doctor) {

    companion object {
        fun newInstance() = DoctorFragment()
    }

    private lateinit var viewModel: DoctorViewModel
    private lateinit var binding: FragmentDoctorBinding
    private lateinit var adapterSpinner: ArrayAdapter<String>

    private var selectedSpecialist: Speciality? = null
    private var selectedDoctor: DoctorWithSpeciality? = null

    private val adapter: DoctorAdapter = DoctorAdapter {
        setValueToFields(it)
    }

    private val observerDoctor = androidx.lifecycle.Observer<List<DoctorWithSpeciality>> {
        adapter.update(it)
    }

    private val observerSpecialist = androidx.lifecycle.Observer<List<Speciality>> {
        val listOf = it.map { category ->
            category.name
        }
        adapterSpinner.addAll(listOf)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DoctorViewModel::class.java)
        binding = FragmentDoctorBinding.bind(view)
        setupRecyclerView()
        startObservers()
        setupForm()
    }


    private fun startObservers() {
        viewModel.doctor.observe(viewLifecycleOwner, observerDoctor)
        viewModel.specialist.observe(viewLifecycleOwner, observerSpecialist)
    }

    private fun setupForm() {

        binding.bottomNew.setOnClickListener {
            val name = binding.textInputLayoutDoctorName.editText?.text.toString()
            if (name.isNotEmpty() && selectedSpecialist != null) {
                viewModel.insertDoctor(
                    Doctor(
                        name_doctor = name,
                        speciality_fk = selectedSpecialist!!.id_specialty
                    )
                )
                clearFields()
            }
        }

        binding.bottomDelete.setOnClickListener {
            selectedDoctor?.doctor?.let {
                viewModel.deleteDoctor(it)
            }
            clearFields()
        }

        binding.bottomEdit.setOnClickListener {
            val name = binding.textInputLayoutDoctorName.editText?.text
            if (name.toString().isNotEmpty() && selectedSpecialist != null) {
                viewModel.updateDoctor(
                    Doctor(
                        name_doctor = name.toString(),
                        speciality_fk = selectedSpecialist!!.id_specialty
                    )
                )
                clearFields()
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerViewDoctor.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerViewDoctor.adapter = adapter
    }


    fun setValueToFields(doctorWithSpecialist: DoctorWithSpeciality) {
        binding.textInputLayoutDoctorName.editText?.setText(doctorWithSpecialist.doctor?.name_doctor)
        binding.bottomNew.visibility = View.GONE

        selectedDoctor = doctorWithSpecialist
        selectedSpecialist = doctorWithSpecialist.speciality
    }

    fun clearFields() {
        binding.textInputLayoutDoctorName.editText?.setText("")
        binding.bottomNew.visibility = View.VISIBLE

        selectedSpecialist = null
        selectedDoctor = null
    }
}