package com.example.moviekotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviekotlin.Source.MainListRepository
import com.example.moviekotlin.ViewModel.MainListViewModel

class MyViewModelFactory constructor(private val repository: MainListRepository) :
    ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainListViewModel::class.java)) {
            MainListViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
    }