package com.example.e_commerce.data.repository

import com.example.e_commerce.data.model.GeneralResponse
import com.example.e_commerce.data.remote.ProductApiClient
import retrofit2.Call

class ProductRepository {
    val apiClient = ProductApiClient().getProductApiService()

    fun getProducts(offset: Int, token: String?) : Call<GeneralResponse>{
        return apiClient.getProducts(token, offset)
    }
}