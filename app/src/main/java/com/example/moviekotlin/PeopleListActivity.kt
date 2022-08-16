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
import com.example.moviekotlin.Model.ResultPeople
import com.example.moviekotlin.Retrofit.RetrofitService
import com.example.moviekotlin.Source.MainListRepository
import com.example.moviekotlin.ViewModel.MainListViewModel
import com.example.moviekotlin.databinding.ActivityPeoplelistBinding

class PeopleListActivity : AppCompatActivity(), RecyclerviewPeopleClickListener {
    private val TAG = "PeopleListActivity"
    private lateinit var binding: ActivityPeoplelistBinding

    lateinit var viewModel: MainListViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = PeopleAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peoplelist)

        binding = ActivityPeoplelistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvurldata.text = intent.getStringExtra("cat") +"\n" + intent.getStringExtra("url")

        //get viewmodel instance using ViewModelProvider.Factory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainListRepository(retrofitService))).get(
                MainListViewModel::class.java
            )

        //set adapter in recyclerview
        binding.recyclerview.adapter = adapter

        //the observer will only receive events if the owner(activity) is in active state
        //invoked when movieList data changes
        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setMovieList(it)
        })

        //invoked when a network exception occurred
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        viewModel.getListPeople()

        adapter.listener = this

        binding.recyclerview.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this@PeopleListActivity)
        }
    }

    override fun onPeopleItemClicked(view: View, people: ResultPeople) {
        val intent = Intent(this, DetailPeopleActivity::class.java).apply {
            putExtra("url", people.url)
        }
        startActivity(intent)
        Toast.makeText(this,
            "URL ${people.url} berhasil di klik",
            Toast.LENGTH_SHORT
        ).show()
    }
}