package com.liilab.android_basics.presentation.screen.campaign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R


class CampaignActivity : AppCompatActivity() {


    private lateinit var recyclerViewCampaign: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campaign)

        recyclerViewCampaign = findViewById(R.id.recycler_view_campaigns)


        val campaigns = getCampaigns()
        val campaignAdapter = CampaignAdapter(context = this, campaigns = campaigns)
        recyclerViewCampaign.adapter = campaignAdapter

    }

    private fun getCampaigns() : ArrayList<XCampaign> {
        val campaigns : ArrayList<XCampaign> = arrayListOf()

        campaigns.add(
            XCampaign(
                title = "How to learn c++",
                icon = "",
                image = "",
                progress = 16.0,
                totalAction = 100,
                completedAction = 16,
                state = "running",
            )
        )

        campaigns.add(
            XCampaign(
                title = "How to learn c++",
                icon = "",
                image = "",
                progress = 100.0,
                totalAction = 100,
                completedAction = 100,
                state = "completed",
            )
        )

        campaigns.add(
            XCampaign(
                title = "How to learn c++",
                icon = "",
                image = "",
                progress = 16.0,
                totalAction = 100,
                completedAction = 16,
                state = "paused",
            )
        )

        campaigns.add(
            XCampaign(
                title = "How to learn c++",
                icon = "",
                image = "",
                progress = 16.0,
                totalAction = 100,
                completedAction = 16,
                state = "running",
            )
        )

        return campaigns
    }
}