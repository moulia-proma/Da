package com.liilab.android_basics.presentation.screen.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.liilab.android_basics.R

class FragmentActivity : AppCompatActivity() {
    private lateinit var navBottom: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        navBottom = findViewById(R.id.bottom_nav)

        navBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    val fragmentManager = supportFragmentManager
                    val fragmentTrasiction = fragmentManager.beginTransaction()
                    fragmentTrasiction.replace(R.id.fragment_container, GreenScreenFragment())
                        .commit()
                }

                R.id.chat -> {
                    val fragmentManager = supportFragmentManager
                    val fragmentTrasiction = fragmentManager.beginTransaction()
                    fragmentTrasiction.replace(R.id.fragment_container, RedScreenFragment())
                        .commit()

                }
            }
            return@setOnItemSelectedListener true
        }


    }

}
