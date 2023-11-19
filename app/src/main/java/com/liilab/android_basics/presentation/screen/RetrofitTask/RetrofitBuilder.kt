package com.liilab.android_basics.presentation.screen.RetrofitTask

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val base_url = "https://media-manager.liilab.com/api/"

    val okhttpclient = OkHttpClient()
            .newBuilder()
            .addInterceptor(RetrofitHeaders)
            .build()


    fun getInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(base_url)
            .client(okhttpclient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}

object RetrofitHeaders : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request()

        requestBuilder.newBuilder().apply {
            addHeader("Package-Name", "com.liilab.video_thumbnail_maker")
            addHeader("App-Secret", "a626d971-6423-4982-883b-3ecb6713a9eb")
        }.build()

        return chain.proceed(requestBuilder)
    }
}