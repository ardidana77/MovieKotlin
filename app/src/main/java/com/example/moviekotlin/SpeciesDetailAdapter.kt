package com.example.moviekotlin

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class SpeciesDetailAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    var urls: String
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                SpeciesProfile(urls)
            }
            1 -> {
                SpeciesPeople(urls)
            }
            2 -> {
                SpeciesFilm(urls)
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}