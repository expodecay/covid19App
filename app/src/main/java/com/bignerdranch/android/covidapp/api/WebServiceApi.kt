package com.bignerdranch.android.covidapp.api

import com.bignerdranch.android.covidapp.Patient
import com.bignerdranch.android.covidapp.model.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface WebServiceApi {

    /*
    @POST("/posts")
    @FormUrlEncoded
    fun sendPatientForm(@Body form: Patient): Call<Patient>

     */
    @GET("Production/patient")
    suspend fun getPost(): Response<Post>

    @POST("Production/patient")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>

    @POST("/")
    suspend fun pushPostTest(
        @Body post: Post
    ): Response<Post>
}