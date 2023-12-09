package com.example.e_commerce.data.repository

import android.util.Log
import com.example.e_commerce.data.model.GeneralResponse
import com.example.e_commerce.data.model.User
import com.example.e_commerce.data.remote.UserApiClient
import retrofit2.Call

class UserRepository {
    val apiClient = UserApiClient().getUserApiService()

    fun authLogin(user: User) : Call<GeneralResponse>{
        Log.e("TAG", "Prueba : " + user.email + ": " + user.password)
        return apiClient.signIn(user)
    }
}