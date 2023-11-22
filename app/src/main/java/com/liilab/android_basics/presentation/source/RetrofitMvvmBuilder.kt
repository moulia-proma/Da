package com.liilab.android_basics.presentation.source

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitMvvmBuilder {
    val base_url = "https://media-manager.liilab.com/api/"
    val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(RetrofitHeader)
        .build()

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}


object RetrofitHeader : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request()

        val r = requestBuilder.newBuilder().apply {
            addHeader("Package-Name", "com.liilab.video_thumbnail_maker")
            addHeader("App-Secret", "a626d971-6423-4982-883b-3ecb6713a9eb")


        }.build()
        return chain.proceed(r)

    }


}