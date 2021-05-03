package com.bignerdranch.android.covidapp.api

import com.bignerdranch.android.covidapp.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private  val retrofit by lazy{
        Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    val api: WebServiceApi by lazy{
        retrofit.create(WebServiceApi::class.java)
    }
}