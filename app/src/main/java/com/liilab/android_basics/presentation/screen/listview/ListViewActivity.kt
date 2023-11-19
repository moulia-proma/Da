package com.liilab.android_basics.presentation.screen.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.liilab.android_basics.R

class ListViewActivity : AppCompatActivity() {

    private lateinit var listViewFruit : ListView

    private var fruits = arrayListOf("Mango", "Orange", "Banana", "Litchi", "Apple", "Olive", "Mango", "Orange", "Banana", "Litchi", "Apple", "Olive")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listViewFruit = findViewById(R.id.list_view_fruit)

        val adapter  = FruitAdapter(context = this, fruits = fruits)
        listViewFruit.adapter = adapter

    }
}