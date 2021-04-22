package com.bignerdranch.android.covidapp.api

import com.bignerdranch.android.covidapp.Patient
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface WebServiceApi {

    @POST("/posts")
    @FormUrlEncoded
    fun sendPatientForm(@Body form: Patient): Call<Patient>
}