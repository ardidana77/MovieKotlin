package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class StarshipProfile(urls: String) : Fragment() {

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
        viewOfLayout = inflater!!.inflate(R.layout.fragment_starshipprofile, container, false)

        tvprofile = viewOfLayout.findViewById(R.id.textprofilestarshipsname)
        var tvmodel: TextView = viewOfLayout.findViewById(R.id.textprofileStarshipmodel)
        var tvmanufact: TextView = viewOfLayout.findViewById(R.id.textprofileStarshipmanufacture)
        var tvcost: TextView = viewOfLayout.findViewById(R.id.textprofileStarshipcost)
        var tvlen: TextView = viewOfLayout.findViewById(R.id.textprofileStarshipleng)
        var tvspeedr: TextView = viewOfLayout.findViewById(R.id.textprofileStarshipspeed)
        var tvcrew: TextView = viewOfLayout.findViewById(R.id.textprofileStarshipcrew)
        var tvpass: TextView = viewOfLayout.findViewById(R.id.textprofileStarshippassenger)
        var tvcapa: TextView = viewOfLayout.findViewById(R.id.textprofileStarshipcapa)
        var tvconsum: TextView = viewOfLayout.findViewById(R.id.textprofileStarshipconsum)
        var tvclass: TextView = viewOfLayout.findViewById(R.id.textprofileStarshipclass)
        var tvhyper: TextView = viewOfLayout.findViewById(R.id.textprofileStarshiphyper)
        var tvmglt: TextView = viewOfLayout.findViewById(R.id.textprofileStarshipmglt)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.starshipLiveData.observe(viewLifecycleOwner) {
            tvprofile.text = it.name
            tvclass.text = it.starship_class
            tvmodel.text = it.model
            tvmanufact.text = it.manufacturer
            tvconsum.text = it.consumables
            tvcost.text = it.cost_in_credits
            tvlen.text = it.length
            tvspeedr.text = it.max_atmosphering_speed
            tvcrew.text = it.crew
            tvpass.text = it.passengers
            tvcapa.text = it.cargo_capacity
            tvhyper.text = it.hyperdrive_rating
            tvmglt.text = it.MGLT
        }

        vm.fetchDataStarship(urls)

        return viewOfLayout
    }
}