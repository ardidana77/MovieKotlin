package com.example.moviekotlin.Source

import com.example.moviekotlin.Retrofit.RetrofitService

class MainListRepository constructor(private val retrofitService: RetrofitService) {

    fun getListPeople() = retrofitService.getListPeople()

    fun getListPlanet() = retrofitService.getAllPlanet()

    fun getListFilms() = retrofitService.getAllFilms()

    fun getListSpecies() = retrofitService.getAllSpecies()

    fun getListVehicles() = retrofitService.getAllVehicles()

    fun getListStarships() = retrofitService.getAllStarships()

}