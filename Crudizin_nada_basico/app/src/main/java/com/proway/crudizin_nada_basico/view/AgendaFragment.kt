package com.proway.crudizin_nada_basico.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.proway.crudizin_nada_basico.R
import com.proway.crudizin_nada_basico.view_model.AgendaViewModel

class AgendaFragment : Fragment() {

    companion object {
        fun newInstance() = AgendaFragment()
    }

    private lateinit var viewModel: AgendaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.agenda_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AgendaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}