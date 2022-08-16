package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class ProfilePeople(urls: String) : Fragment()  {

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
        viewOfLayout = inflater!!.inflate(R.layout.fragment_profilpeople, container, false)

        tvprofile = viewOfLayout.findViewById(R.id.textprofilepeoplename)
        var tvheight: TextView = viewOfLayout.findViewById(R.id.textprofilepeopleheight)
        var tvmass: TextView = viewOfLayout.findViewById(R.id.textprofilepeoplemass)
        var tvhair: TextView = viewOfLayout.findViewById(R.id.textprofilepeoplehair)
        var tvskin: TextView = viewOfLayout.findViewById(R.id.textprofilepeopleskin)
        var tveye: TextView = viewOfLayout.findViewById(R.id.textprofilepeopleeye)
        var tvbirth: TextView = viewOfLayout.findViewById(R.id.textprofilepeoplebirth)
        var tvgender: TextView = viewOfLayout.findViewById(R.id.textprofilepeoplegender)
        var tvhome: TextView = viewOfLayout.findViewById(R.id.textprofilepeoplehome)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.peopleLiveData.observe(viewLifecycleOwner){
            tvprofile.text = it.name
            tvmass.text = it.mass
            tvheight.text = it.height
            tvhair.text = it.hair_color
            tvbirth.text = it.birth_year
            tvskin.text = it.skin_color
            tveye.text = it.eye_color
            tvgender.text = it.gender
            tvhome.text = it.homeworld
        }

        vm.fetchDataPeople(urls)

        return viewOfLayout
    }
}