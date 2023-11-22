package com.liilab.android_basics.presentation.screen.NavigatrionDrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.liilab.android_basics.R
import com.liilab.android_basics.presentation.screen.tablayoutWithViewPager.ViewPagerAdapter
import com.liilab.android_basics.presentation.screen.tablayoutWithViewPager.tabArray

val tobBarItems = arrayOf(
    "SALES",
    "PURCHASES"
)

class ChatFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var tabBar: TabLayout
    private lateinit var viewpager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat2, container, false)
        viewpager = view.findViewById(R.id.view_pagerr)
        tabBar = view.findViewById(R.id.channerlier_tab_layout)


        val adapter = ViewPagerAdapterr(childFragmentManager, lifecycle)
        viewpager.adapter = adapter

        TabLayoutMediator(tabBar, viewpager) { tab, position ->
            tab.text = tobBarItems[position]
        }.attach()
        return view
    }


}