package com.example.moviekotlin

import android.view.View
import com.example.moviekotlin.Model.ResultVehicles

interface RecyclerviewVehiclesCLickListener {

    fun onVehiclesItemClicked(view: View, vehicles: ResultVehicles)

}