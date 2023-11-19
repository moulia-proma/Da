package com.liilab.android_basics.presentation.screen.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R
import android.content.Context
import android.content.res.ColorStateList
import android.util.Log
import android.widget.ProgressBar
import androidx.cardview.widget.CardView


class CustomAdapterDataClass(
    private val context: Context,
    private val marks: ArrayList<Campaign>


) : RecyclerView.Adapter<CustomAdapterDataClass.ViewHolder>() {

    init {
        Log.d("_xyz", "${marks.size}")
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textMarks: TextView = view.findViewById(R.id.text_marks)
        private val textTotal: TextView = view.findViewById(R.id.text_total)
        private val progressBar: ProgressBar = view.findViewById(R.id.progress_bar_download)
        private val textTitle: TextView = view.findViewById(R.id.text_title)
        private val textStatus: TextView = view.findViewById(R.id.text_status)
        private val cardStatus: CardView = view.findViewById(R.id.card_status)

        fun setFruitData(score: String, total: String, mainText: String) {
            textMarks.text = "$score"
            textTotal.text = "$total"
            textTitle.text = "$mainText"
            val currentInt = score.toInt()
            val totalInt = total.toInt()
            val percentage = (currentInt / (totalInt * 1.00)) * 100
            if (score == total) {
                textStatus.text = "Completed"
                progressBar.progress = percentage.toInt()
                progressBar.progressTintList = ColorStateList.valueOf(Color.GREEN);
                cardStatus.setBackgroundColor(Color.GREEN)
            } else {
                progressBar.progress = percentage.toInt()
                textStatus.text = "Paused"
                progressBar.progressTintList = ColorStateList.valueOf(Color.GRAY);
                cardStatus.setBackgroundColor(Color.GRAY)
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.items_video, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentFruit = marks[position].rate
        val total = marks[position].total
        val textTitle = marks[position].textTitle

        holder.setFruitData(currentFruit, total, textTitle)
    }

    override fun getItemCount(): Int {
        return marks.size
    }
}