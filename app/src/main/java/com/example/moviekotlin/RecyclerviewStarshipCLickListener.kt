package com.example.moviekotlin

import android.view.View
import com.example.moviekotlin.Model.ResultStarship

interface RecyclerviewStarshipCLickListener {

    fun onStarshipsItemClicked(view: View, starship: ResultStarship)

}