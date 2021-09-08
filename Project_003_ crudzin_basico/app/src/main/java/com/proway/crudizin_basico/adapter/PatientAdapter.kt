package com.proway.crudizin_basico.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.crudizin_basico.R
import com.proway.crudizin_basico.databinding.ItemPatientBinding
import com.proway.crudizin_basico.model.Patient

class PatientAdapter(val itemClick: (Patient) -> Unit) :
    RecyclerView.Adapter<PatientViewHolder>() {

    private var patients = mutableListOf<Patient>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_patient, parent, false).apply {
            return PatientViewHolder(this)
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
}

class PatientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemPatientBinding.bind(itemView)

    fun bind(patient: Patient) {
        binding.textPatientId.text = "# ${patient.cpf_patient} -"
        binding.textPatientName.text = "${patient.name_patient}"
    }
}