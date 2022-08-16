package com.example.moviekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviekotlin.Model.ResultVehicles
import com.example.moviekotlin.Retrofit.RetrofitService
import com.example.moviekotlin.Source.MainListRepository
import com.example.moviekotlin.ViewModel.MainListViewModel
import com.example.moviekotlin.databinding.ActivityStarshipListBinding
import com.example.moviekotlin.databinding.ActivityVehiclesListBinding

class VehiclesListActivity : AppCompatActivity(), RecyclerviewVehiclesCLickListener {

    private val TAG = "VehiclesListActivity"
    private lateinit var binding: ActivityVehiclesListBinding

    lateinit var viewModel: MainListViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = VehiclesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicles_list)

        binding = ActivityVehiclesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvurlVehicles.text = intent.getStringExtra("cat") +"\n" + intent.getStringExtra("url")

        //get viewmodel instance using ViewModelProvider.Factory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainListRepository(retrofitService))).get(
                MainListViewModel::class.java
            )

        //set adapter in recyclerview
        binding.rcvVehicles.adapter = adapter

        //the observer will only receive events if the owner(activity) is in active state
        //invoked when movieList data changes
        viewModel.vehiclesList.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setVehiclesList(it)
        })

        //invoked when a network exception occurred
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getListVehicles()

        adapter.listener = this

        binding.rcvVehicles.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this@VehiclesListActivity)
        }
    }

    override fun onVehiclesItemClicked(view: View, vehicles: ResultVehicles) {
        val intent = Intent(this, DetailVehiclesActivity::class.java).apply {
            putExtra("url", vehicles.url)
        }
        startActivity(intent)
        Toast.makeText(this,
            "URL ${vehicles.url} berhasil di klik",
            Toast.LENGTH_SHORT
        ).show()
    }
}