package com.liilab.android_basics.presentation.screen.listview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.liilab.android_basics.R

class FruitAdapter(
    private val context: Context,
    private val fruits: ArrayList<String>
) : BaseAdapter() {

    override fun getCount(): Int {
        return fruits.size
    }

    override fun getItem(position: Int): Any {
      return fruits[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder", "InflateParams", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view = LayoutInflater.from(context).inflate(R.layout.item_fruit, null)

        val textFruitName : TextView = view.findViewById(R.id.text_fruit_name)
        val textFruitDesc : TextView = view.findViewById(R.id.text_fruit_description)


        textFruitName.text = "Fruit = ${fruits[position]}"
        textFruitDesc.text = "${fruits[position]} fruit is testy."

        return  view
    }
}