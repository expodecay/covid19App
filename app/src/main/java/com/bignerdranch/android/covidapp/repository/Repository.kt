package com.bignerdranch.android.covidapp.repository

import com.bignerdranch.android.covidapp.api.RetrofitInstance
import com.bignerdranch.android.covidapp.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post>{
        return RetrofitInstance.api.getPost()
    }
}