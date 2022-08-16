package com.example.moviekotlin.Source

import com.example.moviekotlin.Api.CategoryApi
import com.example.moviekotlin.Model.*

class CategoryRepository(private val categoryApi: CategoryApi) {

    suspend fun getCategory() : Category{
        return categoryApi.getCategory()
    }

    suspend fun getDetailPeople(urls: String): DetailPeopleModel{
        return categoryApi.getDetailPeople(urls)
    }

    suspend fun getDetailFilms(urls: String): DetailFilmModel{
        return categoryApi.getDetailFilms(urls)
    }

    suspend fun getDetailPlanet(urls: String): DetailPlanetModel{
        return categoryApi.getDetailPlanet(urls)
    }

    suspend fun getDetailSpecies(urls: String): DetailSpeciesModel{
        return categoryApi.getDetailSpecies(urls)
    }

    suspend fun getDetailVehicles(urls: String): DetailVehiclesModel{
        return categoryApi.getDetailVehicles(urls)
    }

    suspend fun getDetailStarship(urls: String): DetailStarshipModel{
        return categoryApi.getDetailStarship(urls)
    }

}