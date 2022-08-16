package com.example.moviekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviekotlin.Model.ResultSpecies
import com.example.moviekotlin.Retrofit.RetrofitService
import com.example.moviekotlin.Source.MainListRepository
import com.example.moviekotlin.ViewModel.MainListViewModel
import com.example.moviekotlin.databinding.ActivitySpeciesListBinding

class SpeciesListActivity : AppCompatActivity(), RecyclerviewSpeciesClickListener {

    private val TAG = "SpeciesListActivity"
    private lateinit var binding: ActivitySpeciesListBinding

    lateinit var viewModel: MainListViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = SpeciesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_species_list)

        binding = ActivitySpeciesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvurlSpecies.text = intent.getStringExtra("cat") +"\n" + intent.getStringExtra("url")

        //get viewmodel instance using ViewModelProvider.Factory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainListRepository(retrofitService))).get(
                MainListViewModel::class.java
            )

        //set adapter in recyclerview
        binding.rcvSPeciesList.adapter = adapter

        //the observer will only receive events if the owner(activity) is in active state
        //invoked when movieList data changes
        viewModel.speciesList.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setSpeciesList(it)
        })

        //invoked when a network exception occurred
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getListSpecies()

        adapter.listener = this

        binding.rcvSPeciesList.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this@SpeciesListActivity)
        }
    }

    override fun onSpeciesItemClicked(view: View, species: ResultSpecies) {
        val intent = Intent(this, DetailSpeciesActivity::class.java).apply {
            putExtra("url", species.url)
        }
        startActivity(intent)
        Toast.makeText(this,
            "URL ${species.url} berhasil di klik",
            Toast.LENGTH_SHORT
        ).show()
    }
}