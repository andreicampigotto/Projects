package com.proway.crudizin_basico.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proway.crudizin_basico.model.Speciality

class SpecialityAdapter: RecyclerView.Adapter<SpecialityViewHolder>() {

    private var specialities = mutableListOf<Speciality>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialityViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SpecialityViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = specialities.size
}
class SpecialityViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

}