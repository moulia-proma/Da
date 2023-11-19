package com.liilab.android_basics.presentation.screen.campaign

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R


class CampaignAdapter(
    private val context: Context,
    private var campaigns: ArrayList<XCampaign>
) : RecyclerView.Adapter<CampaignAdapter.ViewHolder>() {

    fun setData(data: ArrayList<XCampaign>){
        campaigns=data

       notifyDataSetChanged()

    }




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_campaign, parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val campaign = campaigns[position]
        holder.setCampaign(campaign)
    }

    override fun getItemCount(): Int {
        return campaigns.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textMarks: TextView = view.findViewById(R.id.text_marks)
        private val textTotal: TextView = view.findViewById(R.id.text_total)
        private val progressBar: ProgressBar = view.findViewById(R.id.progress_bar_download)
        private val textTitle: TextView = view.findViewById(R.id.text_title)
        private val textStatus: TextView = view.findViewById(R.id.text_status)
        private val cardStatus: CardView = view.findViewById(R.id.card_status)

        fun setCampaign(campaign: XCampaign) {
            textMarks.text = "${campaign.completedAction}"
            textTotal.text = "${campaign.totalAction}"
            textTitle.text = campaign.title

            progressBar.progress = campaign.progress.toInt()

            if(campaign.state == "running") {
                textStatus.text = "RUNNING"
                progressBar.progressTintList = ColorStateList.valueOf(Color.RED)
                cardStatus.setCardBackgroundColor(Color.RED)

            }
            else if(campaign.state == "completed") {
                textStatus.text = "COMPLETED"
                progressBar.progressTintList = ColorStateList.valueOf(Color.GREEN)
                cardStatus.setCardBackgroundColor(Color.GREEN)
            }
            else {
                textStatus.text = "PAUSED"
                progressBar.progressTintList = ColorStateList.valueOf(Color.GRAY)
                cardStatus.setCardBackgroundColor(Color.GRAY)
            }
        }
    }
}
