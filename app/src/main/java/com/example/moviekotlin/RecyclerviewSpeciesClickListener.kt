package com.example.moviekotlin

import android.view.View
import com.example.moviekotlin.Model.ResultSpecies

interface RecyclerviewSpeciesClickListener {

    fun onSpeciesItemClicked(view: View, species: ResultSpecies)

}