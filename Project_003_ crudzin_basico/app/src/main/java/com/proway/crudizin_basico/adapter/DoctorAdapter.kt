package com.proway.crudizin_basico.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.crudizin_basico.R
import com.proway.crudizin_basico.databinding.ItemDoctorBinding
import com.proway.crudizin_basico.model.Doctor

class DoctorAdapter(val itemClick: (Doctor) -> Unit) :
    RecyclerView.Adapter<DoctorViewHolder>() {

    private var doctors = mutableListOf<Doctor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_doctor, parent, false).apply {
            return DoctorViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        doctors[position].apply {
            holder.bind(this)

            holder.itemView.setOnClickListener {
                itemClick(this)
            }
        }
    }

    override fun getItemCount(): Int = doctors.size

}

class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemDoctorBinding.bind(itemView)

    fun bind(doctor: Doctor) {
        binding.textDoctorName.text = "# ${doctor.name_doctor} -"
        binding.textDoctorSpeciality.text = "${doctor.speciality_fk}"
    }
}