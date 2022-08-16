package com.example.moviekotlin

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class PeopleDetailAdapter (
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    var urls: String
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ProfilePeople(urls)
            }
            1 -> {
                PeopleFilms(urls)
            }
            2 -> {
                PeopleSpecies(urls)
            }
            3 -> {
                PeopleVehicles(urls)
            }
            4 -> {
                PeopleStarship(urls)
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}