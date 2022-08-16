package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class FilmStarship(urls: String) : Fragment() {

    // View Model
    private lateinit var vm: HomeViewModel
    private lateinit var viewOfLayout: View
    private lateinit var tvFilmStarship: TextView
    private var urls = urls

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewOfLayout = inflater!!.inflate(R.layout.fragment_filmstartship, container, false)

        tvFilmStarship = viewOfLayout.findViewById(R.id.tvfilmstarship)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.filmsLiveData.observe(viewLifecycleOwner) {
            tvFilmStarship.text = ""

            for (i in 0 until it.starships.size) {
                tvFilmStarship.append(it.starships[i])
                tvFilmStarship.append("\n")
            }

        }

        vm.fetchDataFilms(urls)

        return viewOfLayout
    }
}