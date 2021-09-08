package com.proway.crudizin_basico.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.proway.crudizin_basico.R
import com.proway.crudizin_basico.databinding.InsertSpecialityBinding
import com.proway.crudizin_basico.model.Speciality
import com.proway.crudizin_basico.view_model.SpecialityViewModel

class InsertSpecialityFragment : Fragment(R.layout.insert_speciality) {

    companion object {
        fun newInstance() = InsertSpecialityFragment()
    }

    private lateinit var binding: InsertSpecialityBinding
    private lateinit var viewModel: SpecialityViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpecialityViewModel::class.java)
        binding = InsertSpecialityBinding.bind(view)
        insert()
    }

    private fun insert() {
        binding.floatingActionButton.setOnClickListener {
            val name = binding.textFieldSpeciality.editText?.text.toString()
            if (name.isNotEmpty()) {
                viewModel.insertSpeciality(
                    Speciality(
                        name = name
                    )
                )
            }
        }
    }
}