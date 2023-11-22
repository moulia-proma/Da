package com.liilab.android_basics.presentation.Repositary

import com.liilab.android_basics.presentation.screen.RetrofitMvvm.Model.UserInfo
import com.liilab.android_basics.presentation.source.RetrofitMvvmBuilder
import com.liilab.android_basics.presentation.source.RetrofitMvvmInterface
import retrofit2.Call

class RetrofitMvvmRepositary {

       suspend fun getUser(): List<UserInfo> {
              val api = RetrofitMvvmBuilder.getInstance().create(RetrofitMvvmInterface::class.java)
              val response = api.getinfo().execute()
              return  response.body() ?: emptyList()
       }



}