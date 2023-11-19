package com.liilab.android_basics.presentation.screen.Retrofit

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object retrofitBuilder {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getRetrofitInstance(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

            .build()
    }


}


object RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()


        request.newBuilder().apply {
            addHeader("package_name", "com.tubeforces.get_sub")
            addHeader("apk_version", "10")
            addHeader("package_name", "com.tubeforces.get_sub")
            addHeader("package_name", "com.tubeforces.get_sub")
            addHeader("package_name", "com.tubeforces.get_sub")
        }


        return chain.proceed(request)
    }

}