package com.example.moviekotlin.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviekotlin.Model.*
import com.example.moviekotlin.Source.CategoryManualParsing
import com.example.moviekotlin.Source.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {
    private val dataRepository = CategoryRepository(CategoryManualParsing())

    val movieLiveData = MutableLiveData<Category>()
    val peopleLiveData = MutableLiveData<DetailPeopleModel>()
    val filmsLiveData = MutableLiveData<DetailFilmModel>()
    val planetsLiveData = MutableLiveData<DetailPlanetModel>()
    val speciesLiveData = MutableLiveData<DetailSpeciesModel>()
    val vehiclesLiveData = MutableLiveData<DetailVehiclesModel>()
    val starshipLiveData = MutableLiveData<DetailStarshipModel>()

    fun fetchData() {
        viewModelScope.launch {
            val movie: Category = withContext(Dispatchers.IO){
                dataRepository.getCategory()
            }
            movieLiveData.value = movie
        }

    }

    fun fetchDataPeople(urls: String) {
        viewModelScope.launch {
            val people: DetailPeopleModel = withContext(Dispatchers.IO){
                dataRepository.getDetailPeople(urls)
            }
            peopleLiveData.value = people
        }

    }

    fun fetchDataFilms(urls: String) {
        viewModelScope.launch {
            val people: DetailFilmModel = withContext(Dispatchers.IO){
                dataRepository.getDetailFilms(urls)
            }
            filmsLiveData.value = people
        }

    }

    fun fetchDataPlanet(urls: String) {
        viewModelScope.launch {
            val planet: DetailPlanetModel = withContext(Dispatchers.IO){
                dataRepository.getDetailPlanet(urls)
            }
            planetsLiveData.value = planet
        }

    }

    fun fetchDataSpecies(urls: String) {
        viewModelScope.launch {
            val species: DetailSpeciesModel = withContext(Dispatchers.IO){
                dataRepository.getDetailSpecies(urls)
            }
            speciesLiveData.value = species
        }

    }

    fun fetchDataVehicles(urls: String) {
        viewModelScope.launch {
            val vehicles: DetailVehiclesModel = withContext(Dispatchers.IO){
                dataRepository.getDetailVehicles(urls)
            }
            vehiclesLiveData.value = vehicles
        }

    }

    fun fetchDataStarship(urls: String) {
        viewModelScope.launch {
            val starship: DetailStarshipModel = withContext(Dispatchers.IO){
                dataRepository.getDetailStarship(urls)
            }
            starshipLiveData.value = starship
        }

    }

}