package com.proway.crudizin_nada_basico.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.crudizin_nada_basico.R
import com.proway.crudizin_nada_basico.databinding.ItemDoctorBinding
import com.proway.crudizin_nada_basico.model.DoctorWithSpeciality


class DoctorAdapter(val itemClick: (DoctorWithSpeciality) -> Unit) :
    RecyclerView.Adapter<DoctorViewHolder>() {

    private var doctors = mutableListOf<DoctorWithSpeciality>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false).let {
                DoctorViewHolder(it)
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

    fun update(newList: List<DoctorWithSpeciality>) {
        doctors = mutableListOf()
        doctors.addAll(newList)
        notifyDataSetChanged()
    }
}

class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemDoctorBinding.bind(itemView)

    fun bind(doctor: DoctorWithSpeciality) {
        binding.textDoctorName.text = "# ${doctor.doctor?.name_doctor} -"
        binding.textDoctorSpeciality.text = "${doctor.speciality?.name}"
    }
}