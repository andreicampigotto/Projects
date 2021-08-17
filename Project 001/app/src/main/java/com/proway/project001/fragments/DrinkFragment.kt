package com.proway.project001.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.proway.project001.R
import com.proway.project001.model.Drink
import com.proway.project001.model.DrinksResponse
import com.proway.project001.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DrinkFragment : Fragment(R.layout.item_drink), Callback<DrinksResponse> {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val call = RetrofitBuilder.getDrinkInstance().getDrink()
        call.enqueue(this)
    }

    override fun onResponse(call: Call<DrinksResponse>, response: Response<DrinksResponse>) {
        var responseBody = response.body()
        responseBody?.apply {
            bind(this.drinks.first())
        }
    }

    override fun onFailure(call: Call<DrinksResponse>, t: Throwable) {
        print("aqui")
    }

    fun bind(drink: Drink){

        val itemView = requireView()

        itemView.findViewById<TextView>(R.id.nameTextView).apply {
            text = drink.strDrink
        }

        itemView.findViewById<TextView>(R.id.categoryTextView).apply {
            text = drink.strCategory
        }

        itemView.findViewById<TextView>(R.id.alchoolTextView).apply {
            text = drink.strAlcoholic
        }

        itemView.findViewById<TextView>(R.id.instructionsTextView).apply {
            text = drink.strInstructions
        }

        itemView.findViewById<ImageView>(R.id.drinkImageView).apply {
            Glide.with(context)
                .load(drink.strDrinkThumb)
                .placeholder(R.drawable.ic_baseline_image_24)
                .into(this)
        }
    }
}