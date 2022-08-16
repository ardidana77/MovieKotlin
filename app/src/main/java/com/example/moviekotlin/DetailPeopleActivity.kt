package com.example.moviekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.moviekotlin.databinding.ActivityDetailPeopleBinding
import com.google.android.material.tabs.TabLayout

class DetailPeopleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPeopleBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_people)
        binding = ActivityDetailPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var url = intent.getStringExtra("url").toString()

        tabLayout = binding.tabLayoutDetailPeople
        viewPager = binding.viewPagerDetailPeople
        tabLayout.addTab(tabLayout.newTab().setText("Profil"))
        tabLayout.addTab(tabLayout.newTab().setText("Films"))
        tabLayout.addTab(tabLayout.newTab().setText("Species"))
        tabLayout.addTab(tabLayout.newTab().setText("Vehicles"))
        tabLayout.addTab(tabLayout.newTab().setText("Starships"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = PeopleDetailAdapter(this, supportFragmentManager, tabLayout.tabCount,url)
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