package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class PlanetResident(urls: String) : Fragment() {

    // View Model
    private lateinit var vm: HomeViewModel
    private lateinit var viewOfLayout: View
    private lateinit var tvPlanetResident: TextView
    private var urls = urls

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater!!.inflate(R.layout.fragment_planetresident, container, false)

        tvPlanetResident = viewOfLayout.findViewById(R.id.tvplanetresident)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.planetsLiveData.observe(viewLifecycleOwner) {
            tvPlanetResident.text = ""

            for (i in 0 until it.residents.size) {
                tvPlanetResident.append(it.residents[i])
                tvPlanetResident.append("\n")
            }
        }

        vm.fetchDataPlanet(urls)

        return viewOfLayout

    }

}