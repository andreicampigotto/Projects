package com.proway.crudizin_nada_basico.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.crudizin_nada_basico.R
import com.proway.crudizin_nada_basico.databinding.ItemPatientBinding
import com.proway.crudizin_nada_basico.model.Patient

class PatientAdapter(val itemClick: (Patient) -> Unit) :
    RecyclerView.Adapter<PatientViewHolder>() {

    private var patients = mutableListOf<Patient>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_patient, parent, false).let {
                PatientViewHolder(it)
            }
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        patients[position].apply {
            holder.bind(this)

            holder.itemView.setOnClickListener {
                itemClick(this)
            }
        }
    }

    override fun getItemCount(): Int = patients.size

    fun update(newList: List<Patient>) {
        patients = mutableListOf()
        patients.addAll(newList)
        notifyDataSetChanged()
    }
}

class PatientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemPatientBinding.bind(itemView)

    fun bind(patient: Patient) {
        binding.textPatientId.text = "# ${patient.pat_id} -"
        binding.textPatientName.text = "${patient.name_patient}"
        binding.textPatientAge.text = "${patient.age} anos "
    }
}

