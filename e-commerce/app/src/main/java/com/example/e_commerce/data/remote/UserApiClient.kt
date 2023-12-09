package com.example.e_commerce.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserApiClient {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://968f-191-156-241-6.ngrok-free.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserApiService(): UserApiService{
        return retrofit.create(UserApiService::class.java)
    }
}