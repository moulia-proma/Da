package com.liilab.android_basics.presentation.screen.NavigatrionDrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.liilab.android_basics.R
import com.liilab.android_basics.presentation.screen.Fragment.GreenScreenFragment

class NavigationDrawerActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var toolbar: MaterialToolbar
    private lateinit var navController: NavController
    private lateinit var navView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration.Builder(navController.graph)
            .setOpenableLayout(drawerLayout)
            .build()

        setupActionBarWithNavController(navController, appBarConfiguration)


        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.chat -> {
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }

                    val fragmentManager = supportFragmentManager
                    val fragmentTrasiction = fragmentManager.beginTransaction()
                    fragmentTrasiction.replace(R.id.nav_host_fragment, ChatFragment())
                        .commit()

                    true

                }

                else -> {

                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    val fragmentManager = supportFragmentManager
                    val fragmentTrasiction = fragmentManager.beginTransaction()
                    fragmentTrasiction.replace(R.id.nav_host_fragment, GreenScreenFragment())
                        .commit()
                    true


                }
            }


        }

//
//        val navController = findNav
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
//
//        findViewById<MaterialToolbar>(R.id.toolbar)
//            .setupWithNavController(navController, appBarConfiguration)


//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//
//        val navController = navHostFragment.navController
//
//        findViewById<NavigationView>(R.id.nav_view).setupWithNavController(navController)

    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
//            true
//        } else super.onOptionsItemSelected(item)
//    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}