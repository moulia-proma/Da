package com.liilab.android_basics.presentation.screen.NavigatrionDrawer

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.liilab.android_basics.presentation.screen.tablayoutWithViewPager.UpdateFragment
import kotlin.math.log

public const val TABS = 2

class ViewPagerAdapterr(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return UpdateFragment()
            1 -> return UpdateFragment()
        }
        return UpdateFragment()
    }
}