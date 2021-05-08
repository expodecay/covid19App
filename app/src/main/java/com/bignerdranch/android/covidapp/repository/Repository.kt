package com.bignerdranch.android.covidapp.repository

import com.bignerdranch.android.covidapp.api.RetrofitInstance
import com.bignerdranch.android.covidapp.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Number>{
        return RetrofitInstance.api.getPost()
    }

    suspend fun AWS(post: Post): Response<Number>{
        return RetrofitInstance.api.AWS(post)
    }

    suspend fun Heroku(post: Post): Response<Number>{
        return RetrofitInstance.api.Heroku(post)
    }
}