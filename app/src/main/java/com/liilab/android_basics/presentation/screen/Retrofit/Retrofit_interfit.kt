package com.liilab.android_basics.presentation.screen.Retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface retrofit_interfit {
    @GET("/photos")
     suspend fun getPhotos(): retrofit2.Response<List<user_infoItem>>

    @FormUrlEncoded
    @POST("users")
    fun postUsersWithPayload(@Body user: user_infoItem): Call<user_infoItem>

}