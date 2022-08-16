package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class VehiclesProfile(urls: String) : Fragment() {

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
        viewOfLayout = inflater!!.inflate(R.layout.fragment_vehiclesprofile, container, false)

        tvprofile = viewOfLayout.findViewById(R.id.textprofilevehiclesname)
        var tvmodel: TextView = viewOfLayout.findViewById(R.id.textprofilevehiclesmodel)
        var tvmanufact: TextView = viewOfLayout.findViewById(R.id.textprofilevehiclesmanufacture)
        var tvcost: TextView = viewOfLayout.findViewById(R.id.textprofilevehiclescost)
        var tvlen: TextView = viewOfLayout.findViewById(R.id.textprofilevehiclesleng)
        var tvspeedr: TextView = viewOfLayout.findViewById(R.id.textprofilevehiclesspeed)
        var tvcrew: TextView = viewOfLayout.findViewById(R.id.textprofilevehiclescrew)
        var tvpass: TextView = viewOfLayout.findViewById(R.id.textprofilevehiclespassenger)
        var tvcapa: TextView = viewOfLayout.findViewById(R.id.textprofilevehiclescapa)
        var tvconsum: TextView = viewOfLayout.findViewById(R.id.textprofilevehiclesconsum)
        var tvclass: TextView = viewOfLayout.findViewById(R.id.textprofilevehiclesclass)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.vehiclesLiveData.observe(viewLifecycleOwner) {
            tvprofile.text = it.name
            tvclass.text = it.vehicle_class
            tvmodel.text = it.model
            tvmanufact.text = it.manufacturer
            tvconsum.text = it.consumables
            tvcost.text = it.cost_in_credits
            tvlen.text = it.length
            tvspeedr.text = it.max_atmosphering_speed
            tvcrew.text = it.crew
            tvpass.text = it.passengers
            tvcapa.text = it.cargo_capacity
        }

        vm.fetchDataVehicles(urls)

        return viewOfLayout
    }
}