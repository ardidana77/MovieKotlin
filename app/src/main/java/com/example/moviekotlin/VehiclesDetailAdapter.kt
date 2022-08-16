package com.example.moviekotlin

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class VehiclesDetailAdapter (
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int,
    var urls: String
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                VehiclesProfile(urls)
            }
            1 -> {
                VehiclesPilot(urls)
            }
            2 -> {
                VehiclesFilms(urls)
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}