package com.proway.crudizin_nada_basico.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.proway.crudizin_nada_basico.R
import com.proway.crudizin_nada_basico.adapter.SpecialityAdapter
import com.proway.crudizin_nada_basico.databinding.FragmentSpecialityBinding
import com.proway.crudizin_nada_basico.model.Speciality
import com.proway.crudizin_nada_basico.view_model.SpecialityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpecialistFragment : Fragment(R.layout.fragment_speciality) {

    companion object {
        fun newInstance() = SpecialistFragment()
    }

    private lateinit var binding: FragmentSpecialityBinding
    private lateinit var viewModel: SpecialityViewModel
    private var selectedSpecialist: Speciality? = null

    private val adapter = SpecialityAdapter {
        selectedSpecialist = it
        binding.bottomNew.visibility = View.GONE
        setValueToFields(it)
    }

    private fun setValueToFields(speciality: Speciality) {
        binding.editNameSpecialist?.setText(speciality.name)
    }

    private val observerSpecialist = Observer<List<Speciality>> {
        adapter.update(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpecialityViewModel::class.java)
        binding = FragmentSpecialityBinding.bind(view)
        viewModel.speciality.observe(viewLifecycleOwner, observerSpecialist)
        viewModel.getAllSpecialisties()
        settingRecyclerView()
        settingForm()

    }

    private fun settingForm() {
        binding.bottomNew.setOnClickListener {
            val name = binding.editNameSpecialist.text.toString()
            if (!name.isNullOrEmpty()) {
                viewModel.insertSpeciality(
                    Speciality(
                        name = name
                    )
                )
                clearFields()
            }
        }
        binding.bottomDelete.setOnClickListener {
            selectedSpecialist?.let {
                viewModel.deleteSpeciality(it)
                clearFields()
            }
        }

        binding.bottomEdit.setOnClickListener {
            selectedSpecialist?.let {
                val name = binding.editNameSpecialist
                if (!name.editableText.isNullOrEmpty()) {
                    viewModel.updateSpeciality(
                        Speciality(
                            name = name.text.toString(),
                            id_speciality = selectedSpecialist!!.id_speciality
                        )
                    )
                    clearFields()
                }
            }
        }
    }

    private fun clearFields() {
        binding.editNameSpecialist?.setText("")
        binding.bottomNew.visibility = View.VISIBLE
    }

    private fun settingRecyclerView() {
        binding.recyclerViewSpecialist.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerViewSpecialist.adapter = adapter
    }
}