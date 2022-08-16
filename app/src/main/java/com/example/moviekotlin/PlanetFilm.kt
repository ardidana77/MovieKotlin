package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class PlanetFilm(urls: String) : Fragment() {

    // View Model
    private lateinit var vm: HomeViewModel
    private lateinit var viewOfLayout: View
    private lateinit var tvPlanetFilm: TextView
    private var urls = urls

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater!!.inflate(R.layout.fragment_planetfilm, container, false)

        tvPlanetFilm = viewOfLayout.findViewById(R.id.tvplanetfilm)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.planetsLiveData.observe(viewLifecycleOwner) {
            tvPlanetFilm.text = ""

            for (i in 0 until it.films.size) {
                tvPlanetFilm.append(it.films[i])
                tvPlanetFilm.append("\n")
            }
        }

        vm.fetchDataPlanet(urls)

        return viewOfLayout

    }
}