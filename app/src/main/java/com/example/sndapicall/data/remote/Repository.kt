package com.example.sndapicall.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sndapicall.data.model.Response

class Repository {
    private val _dogs = MutableLiveData<List<String>>()

    val dogs: LiveData<List<String>>
        get() = _dogs

    suspend fun loadDogs(term: String){
        val response: Response = DogApi.retrofitService.getDoggies(term)
        _dogs.value = response.dogList
    }
}