package com.example.moviekotlin

import android.view.View
import com.example.moviekotlin.Model.ResultPeople

interface RecyclerviewPeopleClickListener {

    fun onPeopleItemClicked(view: View, people: ResultPeople)

}