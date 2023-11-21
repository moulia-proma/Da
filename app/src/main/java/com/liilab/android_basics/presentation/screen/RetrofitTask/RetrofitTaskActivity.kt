package com.liilab.android_basics.presentation.screen.RetrofitTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RetrofitTaskActivity : AppCompatActivity() {
    private lateinit var recyclerViewRetrofit: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campaign)


        val retroApi = RetrofitBuilder.getInstance().create(RetroInterface::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = retroApi.getinfo().execute()
            val responseData = response.body()

            GlobalScope.launch(Dispatchers.Main) {
                recyclerViewRetrofit = findViewById(R.id.recycler_view_campaigns)
                if (responseData != null) {
                    val retrofitAdapter = RetroTaskAdapter(this@RetrofitTaskActivity, responseData)
                    recyclerViewRetrofit.adapter = retrofitAdapter
                }
            }
        }



    }


}