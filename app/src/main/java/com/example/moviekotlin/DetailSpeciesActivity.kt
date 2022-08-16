package com.example.moviekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.moviekotlin.databinding.ActivityDetailPlanetBinding
import com.example.moviekotlin.databinding.ActivityDetailSpeciesBinding
import com.google.android.material.tabs.TabLayout

class DetailSpeciesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailSpeciesBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_species)

        binding = ActivityDetailSpeciesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var url = intent.getStringExtra("url").toString()

        tabLayout = binding.tabLayoutDetailSpecies
        viewPager = binding.viewPagerDetailSpecies
        tabLayout.addTab(tabLayout.newTab().setText("Profil"))
        tabLayout.addTab(tabLayout.newTab().setText("People"))
        tabLayout.addTab(tabLayout.newTab().setText("Film"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = SpeciesDetailAdapter(this, supportFragmentManager, tabLayout.tabCount,url)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {  }

            override fun onTabReselected(tab: TabLayout.Tab?) {  }

        })
    }
}