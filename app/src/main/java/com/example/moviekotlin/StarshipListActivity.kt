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
import com.example.moviekotlin.Model.ResultStarship
import com.example.moviekotlin.Model.ResultVehicles
import com.example.moviekotlin.Retrofit.RetrofitService
import com.example.moviekotlin.Source.MainListRepository
import com.example.moviekotlin.ViewModel.MainListViewModel
import com.example.moviekotlin.databinding.ActivityStarshipListBinding

class StarshipListActivity : AppCompatActivity(), RecyclerviewStarshipCLickListener {

    private val TAG = "StarshipListActivity"
    private lateinit var binding: ActivityStarshipListBinding

    lateinit var viewModel: MainListViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = StarshipAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starship_list)

        binding = ActivityStarshipListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvurlStarship.text = intent.getStringExtra("cat") +"\n" + intent.getStringExtra("url")

        //get viewmodel instance using ViewModelProvider.Factory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainListRepository(retrofitService))).get(
                MainListViewModel::class.java
            )

        //set adapter in recyclerview
        binding.rcvStarshipList.adapter = adapter

        //the observer will only receive events if the owner(activity) is in active state
        //invoked when movieList data changes
        viewModel.starshipList.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setStarshipList(it)
        })

        //invoked when a network exception occurred
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getListStarship()

        adapter.listener = null

        binding.rcvStarshipList.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this@StarshipListActivity)
        }

    }

    override fun onStarshipsItemClicked(view: View, starship: ResultStarship) {
        val intent = Intent(this, DetailStarshipActivity::class.java).apply {
            putExtra("url", starship.url)
        }
        startActivity(intent)
        Toast.makeText(this,
            "URL ${starship.url} berhasil di klik",
            Toast.LENGTH_SHORT
        ).show()
    }
}