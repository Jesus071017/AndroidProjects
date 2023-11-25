package com.example.retrofit.data.remote

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class ApiClient {
    var retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://movie.danydev.co/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    fun getApiService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}