package com.liilab.android_basics.presentation.screen.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R

class CustomAdapter(
    private val context: Context,
    private val fruits: ArrayList<String>
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textFruitName: TextView = view.findViewById(R.id.text_fruit_name)
        private val textFruitDesc: TextView = view.findViewById(R.id.text_fruit_description)
        private val FruitBackground: LinearLayout = view.findViewById(R.id.linear_layout_fruit)

        fun setFruitData(fruit: String, Position: Int) {
            textFruitName.text = "Fruit = $fruit"
            textFruitDesc.text = "$fruit fruit is testy."
            if (Position % 2 == 0) {
                FruitBackground.setBackgroundColor(Color.BLUE)
            } else {
                FruitBackground.setBackgroundColor(Color.BLACK)

            }
        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_fruit, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentFruit = fruits[position]
        holder.setFruitData(fruit = currentFruit, Position = position)
    }
}