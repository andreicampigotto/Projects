package com.proway.project001.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.project001.R
import com.proway.project001.adapter.BeerAdapter
import com.proway.project001.model.Beer
import com.proway.project001.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeerFragment : Fragment(R.layout.fragment_beer), Callback<List<Beer>> {

    lateinit var recyclerView: RecyclerView

    private val adapter = BeerAdapter()
    private val beersCall  = RetrofitBuilder.getBeerInstance().getBeers()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = view.findViewById(R.id.beersRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter
        fetchBeers()
    }


    override fun onResponse(call: Call<List<Beer>>, response: Response<List<Beer>>) {
        response.body()?.apply {
            adapter.update(this)
        }
    }

    private fun fetchBeers() {
        beersCall.clone().enqueue(this)
    }

    override fun onFailure(call: Call<List<Beer>>, t: Throwable) {

    }
}