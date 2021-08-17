package com.proway.project001.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.project001.R
import com.proway.project001.model.Beer
import com.proway.project001.model.Drink

class BeerAdapter: RecyclerView.Adapter<BeerViewHolder>() {

    private var beerlist = mutableListOf<Beer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_beer, parent, false).apply {
            return BeerViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        beerlist[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = beerlist.size

    fun update(newList: List<Beer>){
        beerlist = mutableListOf()
        beerlist.addAll(newList)
        notifyDataSetChanged()
    }
}

class BeerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val beerImageView: ImageView = itemView.findViewById(R.id.beerImageView)
    private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    private val taglineTextView: TextView = itemView.findViewById(R.id.taglineTextView)
    private val textViewIbu: TextView = itemView.findViewById(R.id.textViewIbu)
    private val textViewAbv: TextView = itemView.findViewById(R.id.textViewAbv)
    private val textViewPH: TextView = itemView.findViewById(R.id.textViewPH)
    private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

    fun bind(beer: Beer) {
        nameTextView.text = beer.name
        taglineTextView.text = beer.tagline
        descriptionTextView.text = beer.description
        textViewIbu.text = "IBU ${beer.ibu.toString()}"
        textViewAbv.text = "ABV ${beer.abv.toString()}"
        textViewPH.text = "PH ${beer.ph.toString()}"

        Glide.with(itemView.context)
            .load(beer.image_url)
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(beerImageView)
    }
}

class DrinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


}

