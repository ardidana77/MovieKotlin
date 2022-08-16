package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class StarshipFilms(urls: String) : Fragment() {

    // View Model
    private lateinit var vm: HomeViewModel
    private lateinit var viewOfLayout: View
    private lateinit var tvStarshipFilm: TextView
    private var urls = urls

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater!!.inflate(R.layout.fragment_startshipfilms, container, false)

        tvStarshipFilm = viewOfLayout.findViewById(R.id.tvstarshipFilms)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.starshipLiveData.observe(viewLifecycleOwner) {
            tvStarshipFilm.text = ""

            for (i in 0 until it.films.size) {
                tvStarshipFilm.append(it.films[i])
                tvStarshipFilm.append("\n")
            }
        }

        vm.fetchDataStarship(urls)

        return viewOfLayout

    }

}