package com.example.moviekotlin.Api

import com.example.moviekotlin.Model.*

interface CategoryApi {

    suspend fun getCategory() : Category

    suspend fun getDetailPeople(urls: String): DetailPeopleModel

    suspend fun getDetailFilms(urls: String): DetailFilmModel

    suspend fun getDetailPlanet(urls: String): DetailPlanetModel

    suspend fun getDetailSpecies(urls: String): DetailSpeciesModel

    suspend fun getDetailVehicles(urls: String): DetailVehiclesModel

    suspend fun getDetailStarship(urls: String): DetailStarshipModel

}