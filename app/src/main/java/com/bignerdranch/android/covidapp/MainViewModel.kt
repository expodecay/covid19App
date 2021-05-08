package com.bignerdranch.android.covidapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.covidapp.model.Post
import com.bignerdranch.android.covidapp.repository.Repository
import retrofit2.Response
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Number>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    fun AWS(post: Post){
        viewModelScope.launch {
            val response = repository.AWS(post)
            myResponse.value = response
        }
    }

    fun Heroku(post: Post){
        viewModelScope.launch {
            val response = repository.Heroku(post)
            myResponse.value = response
        }
    }
}