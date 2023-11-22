package com.liilab.android_basics.presentation.source

import com.liilab.android_basics.presentation.screen.RetrofitMvvm.Model.UserInfo
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitMvvmInterface {
    @GET("core/v1/remote-configs/")
fun getinfo() : Call<List<UserInfo>>

}