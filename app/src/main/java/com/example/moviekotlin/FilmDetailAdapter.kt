package com.example.moviekotlin

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class FilmDetailAdapter (
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    var urls: String
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FilmProfile(urls)
            }
            1 -> {
                FilmCharacter(urls)
            }
            2 -> {
                FilmPlanet(urls)
            }
            3 -> {
                FilmStarship(urls)
            }
            4 -> {
                FilmVehicles(urls)
            }
            5 -> {
                FilmSpecies(urls)
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}