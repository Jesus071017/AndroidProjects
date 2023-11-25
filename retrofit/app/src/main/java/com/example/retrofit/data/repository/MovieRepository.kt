package com.example.retrofit.data.repository

import retrofit2.Call
import com.example.retrofit.data.model.Movie
import com.example.retrofit.data.remote.ApiClient
import retrofit2.Callback

class MovieRepository {
    val apiClient = ApiClient().getApiService()

    fun getMovies() = apiClient.getMovies()

    fun getMovies2(): Call<List<Movie>> {
        return apiClient.getMovies()
    }

    fun getMovies3(callback: Callback<List<Movie>>) {
        apiClient.getMovies().enqueue(callback)
    }
}
