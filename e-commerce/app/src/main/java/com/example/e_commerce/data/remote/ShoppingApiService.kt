package com.example.e_commerce.data.remote

import com.example.e_commerce.data.model.GeneralResponse
import com.example.e_commerce.data.model.Shopping
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ShoppingApiService {
    @POST("show_shopping")
    fun showShopping(@Body shopping: Shopping): Call<GeneralResponse>

    @POST("create_shopping")
    fun createShopping(@Body shopping: Shopping): Call<GeneralResponse>
}