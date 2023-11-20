package com.liilab.android_basics.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import com.liilab.android_basics.R

class TempActivity : AppCompatActivity() {
    private lateinit var cardVipPlan : MaterialCardView
    private lateinit var textName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardVipPlan = findViewById(R.id.card_vip_plan)
        textName =  findViewById(R.id.text_name)

        cardVipPlan.setOnClickListener {
            textName.text = "Proma VIP"
        }

    }
}