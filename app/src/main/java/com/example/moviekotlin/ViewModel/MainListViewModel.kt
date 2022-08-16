package com.example.moviekotlin.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviekotlin.Model.*
import com.example.moviekotlin.Source.MainListRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainListViewModel(private val repository: MainListRepository) : ViewModel() {

    val movieList = MutableLiveData<List<ResultPeople>>()
    val planetList = MutableLiveData<List<ResultPlanet>>()
    val filmsList = MutableLiveData<List<ResultFilms>>()
    val speciesList = MutableLiveData<List<ResultSpecies>>()
    val vehiclesList = MutableLiveData<List<ResultVehicles>>()
    val starshipList = MutableLiveData<List<ResultStarship>>()

    val errorMessage = MutableLiveData<String>()

    fun getListPeople() {

        val response = repository.getListPeople()
        response.enqueue(object : Callback<PeopleModel> {
            override fun onResponse(call: Call<PeopleModel>, response: Response<PeopleModel>) {
                movieList.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<PeopleModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun getListPlanet() {

        val response = repository.getListPlanet()
        response.enqueue(object : Callback<PlanetModel> {
            override fun onResponse(call: Call<PlanetModel>, response: Response<PlanetModel>) {
                planetList.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<PlanetModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun getListFilms() {

        val response = repository.getListFilms()
        response.enqueue(object : Callback<FilmModel> {
            override fun onResponse(call: Call<FilmModel>, response: Response<FilmModel>) {
                filmsList.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<FilmModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun getListSpecies() {

        val response = repository.getListSpecies()
        response.enqueue(object : Callback<SpeciesModel> {
            override fun onResponse(call: Call<SpeciesModel>, response: Response<SpeciesModel>) {
                speciesList.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<SpeciesModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }


    fun getListVehicles() {

        val response = repository.getListVehicles()
        response.enqueue(object : Callback<VehiclesModel> {
            override fun onResponse(call: Call<VehiclesModel>, response: Response<VehiclesModel>) {
                vehiclesList.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<VehiclesModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun getListStarship() {

        val response = repository.getListStarships()
        response.enqueue(object : Callback<StarshipModel> {
            override fun onResponse(call: Call<StarshipModel>, response: Response<StarshipModel>) {
                starshipList.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<StarshipModel>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }


}