package com.liilab.android_basics.presentation.screen.RetrofitTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R
import com.liilab.android_basics.presentation.screen.Retrofit.RetrofitAdaptar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Headers

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