package com.liilab.android_basics.presentation.screen.Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class RetrofitActivity : AppCompatActivity() {
    private lateinit var recyclerViewRetrofit: RecyclerView

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campaign)
        val photosApi = retrofitBuilder.getRetrofitInstance()?.create(retrofit_interfit::class.java)





        GlobalScope.launch(Dispatchers.IO) {
            val result = photosApi?.getPhotos()




            if (result?.isSuccessful != null) {
                val resultData = result.body()
                recyclerViewRetrofit = findViewById(R.id.recycler_view_campaigns)

                if (resultData != null) {
                    withContext(Dispatchers.Main) {
                        val retrofitAdapter = RetrofitAdaptar(this@RetrofitActivity, resultData)
                        recyclerViewRetrofit.adapter = retrofitAdapter
                    }
                }


            }

            if (result != null) {
                Log.d("Result", result.body().toString())
            }
        }


    }
}