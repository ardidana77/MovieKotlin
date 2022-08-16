package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class VehiclesFilms(urls: String) : Fragment() {

    // View Model
    private lateinit var vm: HomeViewModel
    private lateinit var viewOfLayout: View
    private lateinit var tvSpeciesFilm: TextView
    private var urls = urls

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater!!.inflate(R.layout.fragment_vehiclesfilms, container, false)

        tvSpeciesFilm = viewOfLayout.findViewById(R.id.tvvehiclesFilm)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.vehiclesLiveData.observe(viewLifecycleOwner) {
            tvSpeciesFilm.text = ""

            for (i in 0 until it.films.size) {
                tvSpeciesFilm.append(it.films[i])
                tvSpeciesFilm.append("\n")
            }
        }

        vm.fetchDataVehicles(urls)

        return viewOfLayout

    }

}