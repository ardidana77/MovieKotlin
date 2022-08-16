package com.example.moviekotlin

import android.view.View
import com.example.moviekotlin.Model.*

interface RecyclerviewFilmClickListener {

    // method yang akan dipanggil di MainActivity
    fun onFilmsItemClicked(view: View, films: ResultFilms)

//    fun onStarshipsItemClicked(view: View, starship: ResultStarship)
//
//    fun onVehiclesItemClicked(view: View, vehicles: ResultVehicles)

}