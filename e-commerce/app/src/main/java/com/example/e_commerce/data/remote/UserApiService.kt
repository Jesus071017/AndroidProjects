package com.example.e_commerce.data.remote

import com.example.e_commerce.data.model.GeneralResponse
import com.example.e_commerce.data.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {
    @POST("customer_sign_up")
    fun customerSignUp(@Body user: User): Call<GeneralResponse>

    @POST("sign_in")
    fun signIn(@Body user: User): Call<GeneralResponse>

    @POST("admin_sign_up")
    fun adminSignUp(@Body user: User): Call<GeneralResponse>
}