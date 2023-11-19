package com.liilab.android_basics.presentation.screen.RetrofitTask

import retrofit2.Call
import retrofit2.http.GET

interface RetroInterface {
    @GET("core/v1/remote-configs/")
   fun getinfo(): Call<List<informationItem>>

}