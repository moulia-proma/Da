package com.liilab.android_basics.presentation.screen.tablayoutWithViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.liilab.android_basics.R

val tabArray = arrayOf(
    "chat",
    "update"
)

class TablayoutActivity : AppCompatActivity() {
    private lateinit var viewpager: ViewPager2
    private lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout)


        viewpager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)


        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewpager.adapter = adapter

        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.text = tabArray[position]
        }.attach()

    }
}