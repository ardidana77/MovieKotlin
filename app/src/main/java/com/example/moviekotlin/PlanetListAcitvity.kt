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
import com.example.moviekotlin.Model.ResultPlanet
import com.example.moviekotlin.Retrofit.RetrofitService
import com.example.moviekotlin.Source.MainListRepository
import com.example.moviekotlin.ViewModel.MainListViewModel
import com.example.moviekotlin.databinding.ActivityPlanetListAcitvityBinding

class PlanetListAcitvity : AppCompatActivity(), RecyclerviewPlanetCLickListener {

    private val TAG = "PlanetListActivity"
    private lateinit var binding: ActivityPlanetListAcitvityBinding

    lateinit var viewModel: MainListViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = PlanetAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_list_acitvity)

        binding = ActivityPlanetListAcitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvUrlDataPlanet.text = intent.getStringExtra("cat") + "\n" + intent.getStringExtra("url")

        //get viewmodel instance using ViewModelProvider.Factory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainListRepository(retrofitService))).get(
                MainListViewModel::class.java
            )

        //set adapter in recyclerview
        binding.rcvPlanetList.adapter = adapter

        //the observer will only receive events if the owner(activity) is in active state
        //invoked when movieList data changes
        viewModel.planetList.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setPlanetList(it)
        })

        //invoked when a network exception occurred
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getListPlanet()

        adapter.listener = this

        binding.rcvPlanetList.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this@PlanetListAcitvity)
        }
    }

    override fun onPlanetItemClicked(view: View, planet: ResultPlanet) {
        val intent = Intent(this, DetailPlanetActivity::class.java).apply {
            putExtra("url", planet.url)
        }
        startActivity(intent)
        Toast.makeText(this,
            "URL ${planet.url} berhasil di klik",
            Toast.LENGTH_SHORT
        ).show()
    }
}