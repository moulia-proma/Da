package com.liilab.android_basics.presentation.screen.RetrofitTask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R
import com.liilab.android_basics.presentation.screen.Retrofit.RetrofitAdaptar

class RetroTaskAdapter(
    private val context: Context,
    private val data: List<informationItem>
) : RecyclerView.Adapter<RetroTaskAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetroTaskAdapter.ViewHolder {
        val Retrofitview = LayoutInflater.from(context).inflate(R.layout.item_fruit, parent, false)

        return RetroTaskAdapter.ViewHolder(Retrofitview)
    }

    override fun onBindViewHolder(holder: RetroTaskAdapter.ViewHolder, position: Int) {
        val posData = data[position]
        holder.setData(posData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.text_fruit_name)
        private val des: TextView = view.findViewById(R.id.text_fruit_description)

        fun setData(dataPos: informationItem) {
            title.text = dataPos.key
            des.text = dataPos.value


        }

    }

}