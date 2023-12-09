package com.example.e_commerce.data.remote

import com.example.e_commerce.data.model.GeneralResponse
import com.example.e_commerce.data.model.Product
import com.example.e_commerce.data.model.Shopping
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ProductApiService {
    @POST("show_product")
    fun getProducts(@Header("Authorization") token: String?, @Body offset: Int): Call<GeneralResponse>

    @POST("create_product")
    fun createProduct(@Body product: Product): Call<GeneralResponse>

    @POST("update_product")
    fun updateProduct(@Body product: Product): Call<GeneralResponse>

    @POST("delete_product")
    fun deleteProduct(@Body product: Product): Call<GeneralResponse>

    @POST("add_product_shopping_cart")
    fun addProductShoppingCart(@Body shopping: List<Shopping>): Call<GeneralResponse>

    @POST("add_product_liked")
    fun addProductLiked(@Body shopping: List<Shopping>): Call<GeneralResponse>

    @POST("show_product_liked")
    fun showProductLiked(@Body shopping: Shopping): Call<GeneralResponse>

    @POST("create_product_type")
    fun createProductType(@Body product: Product): Call<GeneralResponse>

    @GET("show_product_type")
    fun showProductType(): Call<GeneralResponse>
}