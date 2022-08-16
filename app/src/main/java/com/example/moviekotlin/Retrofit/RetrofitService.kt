package com.example.moviekotlin.Retrofit

import com.example.moviekotlin.Model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("people")
    fun getListPeople(): Call<PeopleModel>

    @GET("planets")
    fun getAllPlanet(): Call<PlanetModel>

    @GET("films")
    fun getAllFilms(): Call<FilmModel>

    @GET("species")
    fun getAllSpecies(): Call<SpeciesModel>

    @GET("vehicles")
    fun getAllVehicles(): Call<VehiclesModel>

    @GET("starships")
    fun getAllStarships(): Call<StarshipModel>

    companion object {

        var retrofitService: RetrofitService? = null

        //Create the RetrofitService instance using the retrofit.
        fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://swapi.dev/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}