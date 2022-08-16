package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class PeopleFilms(urls: String) : Fragment() {

    private lateinit var vm: HomeViewModel
    private lateinit var viewOfLayout: View
    private lateinit var tvprofile: TextView
    private var urls = urls

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater!!.inflate(R.layout.fragment_peoplefilm, container, false)

        tvprofile = viewOfLayout.findViewById(R.id.tvpeoplefilm)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.peopleLiveData.observe(viewLifecycleOwner){
            tvprofile.text = ""

            for (i in 0 until it.films.size){
                tvprofile.append(it.films[i])
                tvprofile.append("\n")
            }
        }

        vm.fetchDataPeople(urls)

        return viewOfLayout
    }
}