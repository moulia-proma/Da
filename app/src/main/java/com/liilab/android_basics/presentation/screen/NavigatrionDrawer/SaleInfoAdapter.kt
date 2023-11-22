package com.liilab.android_basics.presentation.screen.NavigatrionDrawer

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liilab.android_basics.R

class SaleInfoAdapter(
    private val context: Context,
    private val fruits: ArrayList<SaleInfoItems>
) : RecyclerView.Adapter<SaleInfoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgSale: ImageView = view.findViewById(R.id.img_sale)
        private val textSale: TextView = view.findViewById(R.id.txt_sale)
        private  val view :View = view

        fun setFruitData(items: SaleInfoItems) {
            textSale.text = items.label

            Glide
                .with(view)
                .load(items.url)
                .placeholder(R.drawable.ic_chat)
                .centerCrop()
                .error(R.drawable.ic_close)
                .into(imgSale)

        }
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sale_items, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentFruit = fruits[position]
        holder.setFruitData(items = currentFruit)
    }
}