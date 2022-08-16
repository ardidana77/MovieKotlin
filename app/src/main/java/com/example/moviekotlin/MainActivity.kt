package com.example.moviekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.ViewModel.HomeViewModel
import com.example.moviekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var urlPeople: String
    private lateinit var urlFilm: String
    private lateinit var urlPlanet: String
    private lateinit var urlSpecies: String
    private lateinit var urlVehicles: String
    private lateinit var urlStarships: String

    // View binding
    private lateinit var binding: ActivityMainBinding

    // View Model
    private lateinit var vm: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        vm.movieLiveData.observe(this){
            binding.btnFilm.text = "Film \n" + it.films
            binding.btnPeople.text = "People \n" + it.people
            binding.btnPlanet.text = "Planet \n" + it.planets
            binding.btnSpecies.text = "Species \n" + it.species
            binding.btnStarship.text = "Starship \n" + it.starships
            binding.btnVehicles.text = "Vehicles \n" + it.vehicles

            urlFilm = it.films
            urlPeople = it.people
            urlPlanet = it.planets
            urlSpecies = it.species
            urlVehicles = it.vehicles
            urlStarships = it.starships
        }

        vm.fetchData()

    }

    fun listPoeple(view: View){
        val intent = Intent(this, PeopleListActivity::class.java).apply {
            putExtra("url", urlPeople)
            putExtra("cat","People")
        }
        startActivity(intent)

    }

    fun listFilms(view: View){
        val intent = Intent(this, FilmListActivity::class.java).apply {
            putExtra("url", urlFilm)
            putExtra("cat","Film")
        }
        startActivity(intent)
    }

    fun ListPlanet(view: View){
        val intent = Intent(this, PlanetListAcitvity::class.java).apply {
            putExtra("url", urlPlanet)
            putExtra("cat","Planet")
        }
        startActivity(intent)
    }

    fun ListSpecies(view: View){
        val intent = Intent(this, SpeciesListActivity::class.java).apply {
            putExtra("url", urlSpecies)
            putExtra("cat","Species")
        }
        startActivity(intent)
    }

    fun ListVehicles(view: View){
        val intent = Intent(this, VehiclesListActivity::class.java).apply {
            putExtra("url", urlVehicles)
            putExtra("cat","Vehicles")
        }
        startActivity(intent)
    }

    fun ListStarships(view: View){
        val intent = Intent(this, StarshipListActivity::class.java).apply {
            putExtra("url", urlStarships)
            putExtra("cat","Starships")
        }
        startActivity(intent)
    }
}