package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class PlanetProfile(urls: String) : Fragment() {

    // View Model
    private lateinit var vm: HomeViewModel
    private lateinit var viewOfLayout: View
    private lateinit var tvprofile: TextView
    private var urls = urls

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater!!.inflate(R.layout.fragment_planetprofile, container, false)

        tvprofile = viewOfLayout.findViewById(R.id.textprofileplanetname)
        var tvrotation: TextView = viewOfLayout.findViewById(R.id.textprofileplanetrotation)
        var tvorbital: TextView = viewOfLayout.findViewById(R.id.textprofileplanetorbital)
        var tvdiameter: TextView = viewOfLayout.findViewById(R.id.textprofileplanetdiameter)
        var tvclimate: TextView = viewOfLayout.findViewById(R.id.textprofileplanetclimate)
        var tvgravity: TextView = viewOfLayout.findViewById(R.id.textprofileplanetgravity)
        var tvterrain: TextView = viewOfLayout.findViewById(R.id.textprofileplanetterrain)
        var tvsurface: TextView = viewOfLayout.findViewById(R.id.textprofileplanetsurface)
        var tvPopulate: TextView = viewOfLayout.findViewById(R.id.textprofileplanetpopulation)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.planetsLiveData.observe(viewLifecycleOwner) {
            tvprofile.text = it.name
            tvrotation.text = it.rotation_period
            tvdiameter.text = it.diameter
            tvorbital.text = it.orbital_period
            tvclimate.text = it.climate
            tvgravity.text = it.gravity
            tvterrain.text = it.terrain
            tvsurface.text = it.surface_water
            tvPopulate.text = it.population
        }

        vm.fetchDataPlanet(urls)

        return viewOfLayout
    }
}