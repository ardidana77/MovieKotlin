package com.example.moviekotlin

import android.view.View
import com.example.moviekotlin.Model.ResultPlanet

interface RecyclerviewPlanetCLickListener {

    fun onPlanetItemClicked(view: View, planet: ResultPlanet)
}