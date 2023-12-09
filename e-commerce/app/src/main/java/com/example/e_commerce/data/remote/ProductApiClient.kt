package com.example.e_commerce.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ProductApiClient {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(" https://968f-191-156-241-6.ngrok-free.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getProductApiService(): ProductApiService{
        return retrofit.create(ProductApiService::class.java)
    }
}