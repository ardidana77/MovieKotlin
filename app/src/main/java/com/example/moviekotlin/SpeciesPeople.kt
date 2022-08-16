package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class SpeciesPeople(urls: String) : Fragment() {

    // View Model
    private lateinit var vm: HomeViewModel
    private lateinit var viewOfLayout: View
    private lateinit var tvSpeciesPeople: TextView
    private var urls = urls

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater!!.inflate(R.layout.fragment_speciespeople, container, false)

        tvSpeciesPeople = viewOfLayout.findViewById(R.id.tvspeciespeople)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.speciesLiveData.observe(viewLifecycleOwner) {
            tvSpeciesPeople.text = ""

            for (i in 0 until it.people.size) {
                tvSpeciesPeople.append(it.people[i])
                tvSpeciesPeople.append("\n")
            }
        }

        vm.fetchDataSpecies(urls)

        return viewOfLayout

    }

}