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
import com.example.moviekotlin.Model.ResultFilms
import com.example.moviekotlin.Retrofit.RetrofitService
import com.example.moviekotlin.Source.MainListRepository
import com.example.moviekotlin.ViewModel.MainListViewModel
import com.example.moviekotlin.databinding.ActivityFilmListBinding

class FilmListActivity : AppCompatActivity(), RecyclerviewFilmClickListener {

    private val TAG = "FilmListActivity"
    private lateinit var binding: ActivityFilmListBinding

    lateinit var viewModel: MainListViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = FilmAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_list)

        binding = ActivityFilmListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvurlFilm.text = intent.getStringExtra("cat") +"\n" + intent.getStringExtra("url")

        //get viewmodel instance using ViewModelProvider.Factory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainListRepository(retrofitService))).get(
                MainListViewModel::class.java
            )

        //set adapter in recyclerview
        binding.rcvFilmList.adapter = adapter

        //the observer will only receive events if the owner(activity) is in active state
        //invoked when movieList data changes
        viewModel.filmsList.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setFilmList(it)
        })

        //invoked when a network exception occurred
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getListFilms()

        adapter.listener = this

        binding.rcvFilmList.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this@FilmListActivity)
        }
    }

    override fun onFilmsItemClicked(view: View, films: ResultFilms) {
        val intent = Intent(this, DetailFilmActivity::class.java).apply {
            putExtra("url", films.url)
        }
        startActivity(intent)
        Toast.makeText(this,
            "URL ${films.url} berhasil di klik",
            Toast.LENGTH_SHORT
        ).show()
    }


}