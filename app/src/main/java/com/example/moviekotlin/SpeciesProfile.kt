package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class SpeciesProfile(urls: String) : Fragment() {

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
        viewOfLayout = inflater!!.inflate(R.layout.fragment_speciesprofile, container, false)

        tvprofile = viewOfLayout.findViewById(R.id.textprofilespeciesname)
        var tvclass: TextView = viewOfLayout.findViewById(R.id.textprofilespeciesclass)
        var tvdesign: TextView = viewOfLayout.findViewById(R.id.textprofilespeciesdesign)
        var tvheight: TextView = viewOfLayout.findViewById(R.id.textprofilespeciesheight)
        var tvskin: TextView = viewOfLayout.findViewById(R.id.textprofilespeciesskin)
        var tvhair: TextView = viewOfLayout.findViewById(R.id.textprofilespecieshair)
        var tveye: TextView = viewOfLayout.findViewById(R.id.textprofilespecieseye)
        var tvlifespan: TextView = viewOfLayout.findViewById(R.id.textprofilespecieslifespan)
        var tvhome: TextView = viewOfLayout.findViewById(R.id.textprofilespecieshome)
        var tvLanguage: TextView = viewOfLayout.findViewById(R.id.textprofilespecieslanguage)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.speciesLiveData.observe(viewLifecycleOwner) {
            tvprofile.text = it.name
            tvclass.text = it.classification
            tvdesign.text = it.designation
            tvheight.text = it.average_height
            tvskin.text = it.skin_colors
            tvhair.text = it.hair_colors
            tveye.text = it.eye_colors
            tvlifespan.text = it.average_lifespan
            tvhome.text = it.homeworld.toString()
            tvLanguage.text = it.language
        }

        vm.fetchDataSpecies(urls)

        return viewOfLayout
    }

}