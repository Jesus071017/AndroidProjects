package com.example.e_commerce.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ShoppingApiClient {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://127.0.0.1:5000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getShoppingApiService(): ShoppingApiService{
        return retrofit.create(ShoppingApiService::class.java)
    }
}