package com.proway.crudizin_basico.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.proway.crudizin_basico.R
import com.proway.crudizin_basico.adapter.SpecialityAdapter
import com.proway.crudizin_basico.databinding.FragmentSpecialityBinding
import com.proway.crudizin_basico.model.Speciality
import com.proway.crudizin_basico.view_model.SpecialityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SpecialityFragment : Fragment(R.layout.fragment_speciality) {

    companion object {
        fun newInstance() = SpecialityFragment()
    }

    private lateinit var binding: FragmentSpecialityBinding
    private lateinit var viewModel: SpecialityViewModel
    private var selectedSpeciality: Speciality? = null

    private val adapter = SpecialityAdapter {
        selectedSpeciality = it
    }

    private val observerSpecialist = Observer<List<Speciality>> {
        adapter.refresh(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpecialityViewModel::class.java)
        binding = FragmentSpecialityBinding.bind(view)
        viewModel.speciality.observe(viewLifecycleOwner, observerSpecialist)
        viewModel.getAllSpecialisties()
        settingRecyclerView()
    }

    private fun settingRecyclerView() {
        binding.recyclerViewSpeciality.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerViewSpeciality.adapter = adapter
    }

}