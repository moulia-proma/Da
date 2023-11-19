package com.liilab.android_basics.presentation.screen.campaign

data class XCampaign(
   val  title: String,
    val icon: String,
    val image: String,
    val totalAction: Int,
    val progress: Double,
    val completedAction: Int,
    val state: String
)