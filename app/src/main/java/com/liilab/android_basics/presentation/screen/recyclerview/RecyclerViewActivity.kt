package com.liilab.android_basics.presentation.screen.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R

class RecyclerViewActivity : AppCompatActivity() {

    private var fruits = arrayListOf(
        "Mango", "Orange", "Banana", "Litchi", "Apple", "Olive",
        "Mango", "Orange", "Banana", "Litchi", "Apple", "Olive",
        "Mango", "Orange", "Banana", "Litchi", "Apple", "Olive",
        "Mango", "Orange", "Banana", "Litchi", "Apple", "Olive"
    )

    private lateinit var recyclerViewFruit : RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerViewFruit = findViewById(R.id.recycler_view_fruits)
        val adapter = CustomAdapter(context = this, fruits = fruits)

        recyclerViewFruit.adapter = adapter

    }
}
