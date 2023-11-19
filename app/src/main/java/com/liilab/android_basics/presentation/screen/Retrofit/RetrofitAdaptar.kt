package com.liilab.android_basics.presentation.screen.Retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R
import kotlinx.coroutines.CoroutineScope

class RetrofitAdaptar(
    private val context: Context,
    private val data: List<user_infoItem>
) : RecyclerView.Adapter<RetrofitAdaptar.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val Retrofitview = LayoutInflater.from(context).inflate(R.layout.item_fruit, parent, false)

        return RetrofitAdaptar.ViewHolder(Retrofitview)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataPos = data?.get(position)
        holder.setData(dataPos)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textMarks: TextView = view.findViewById(R.id.text_fruit_name)

        fun setData(dataPos: user_infoItem?) {
            textMarks.text = "${dataPos?.title}"

        }

    }

}