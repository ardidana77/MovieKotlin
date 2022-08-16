package com.example.moviekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel

class FilmProfile(urls: String) : Fragment() {

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
        viewOfLayout = inflater!!.inflate(R.layout.fragment_profilefilm, container, false)

        tvprofile = viewOfLayout.findViewById(R.id.textprofilefilmtitle)
        var tvEpisode: TextView = viewOfLayout.findViewById(R.id.textprofilefilmepisode)
        var tvOpening: TextView = viewOfLayout.findViewById(R.id.textprofilefilmopening)
        var tvDirector: TextView = viewOfLayout.findViewById(R.id.textprofilefilmdirector)
        var tvProducer: TextView = viewOfLayout.findViewById(R.id.textprofilefilmproducer)
        var tvdate: TextView = viewOfLayout.findViewById(R.id.textprofilefilmdate)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.filmsLiveData.observe(viewLifecycleOwner) {
            tvprofile.text = it.title
            tvEpisode.text = it.episode_id.toString()
            tvOpening.text = it.opening_crawl
            tvDirector.text = it.director
            tvProducer.text = it.producer
            tvdate.text = it.release_date

        }

        vm.fetchDataFilms(urls)

        return viewOfLayout
    }
}