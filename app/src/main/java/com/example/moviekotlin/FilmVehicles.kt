package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class FilmVehicles(urls: String) : Fragment() {

    // View Model
    private lateinit var vm: HomeViewModel
    private lateinit var viewOfLayout: View
    private lateinit var tvFilmVehicles: TextView
    private var urls = urls

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater!!.inflate(R.layout.fragment_filmvehicles, container, false)

        tvFilmVehicles = viewOfLayout.findViewById(R.id.tvfilmvehicles)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.filmsLiveData.observe(viewLifecycleOwner) {
            tvFilmVehicles.text = ""

            for (i in 0 until it.vehicles.size) {
                tvFilmVehicles.append(it.vehicles[i])
                tvFilmVehicles.append("\n")
            }

        }

        vm.fetchDataFilms(urls)

        return viewOfLayout
    }

}