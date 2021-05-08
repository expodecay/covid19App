package com.bignerdranch.android.covidapp.api

import com.bignerdranch.android.covidapp.Patient
import com.bignerdranch.android.covidapp.model.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface WebServiceApi {
    /*
    @POST("/posts")
    @FormUrlEncoded
    fun sendPatientForm(@Body form: Patient): Call<Patient>

     */
    @GET("Production/patient")
    suspend fun getPost(): Response<Post>

    @POST("Production/patient")
    suspend fun AWS(
        @Body post: Post
    ): Response<Number>

    @POST("/")
    suspend fun Heroku(
        @Body post: Post
    ): Response<Post>
}