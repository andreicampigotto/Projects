package com.proway.crudizin_basico.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.crudizin_basico.R
import com.proway.crudizin_basico.databinding.ItemSpecialityBinding
import com.proway.crudizin_basico.model.Speciality

class SpecialityAdapter(val itemClick: (Speciality) -> Unit) :
    RecyclerView.Adapter<SpecialityViewHolder>() {

    private var specialities = mutableListOf<Speciality>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialityViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_speciality, parent, false).let {
                SpecialityViewHolder(it)
            }
    }

    override fun onBindViewHolder(holder: SpecialityViewHolder, position: Int) {
        specialities[position].apply {
            holder.bind(this)
            holder.itemView.setOnClickListener {
                itemClick(this)
            }
        }
    }

    override fun getItemCount(): Int = specialities.size

    fun update(newList: List<Speciality>) {
        specialities = mutableListOf()
        specialities.addAll(newList)
        notifyDataSetChanged()
    }

}
class SpecialityViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    private val binding = ItemSpecialityBinding.bind(itemView)

    fun bind(specialist: Speciality) {
        binding.textSpecialityId.text = "# ${specialist.id_specialty.toString()} -"
        binding.textSpecialityName.text = "${specialist.name}"
    }
}