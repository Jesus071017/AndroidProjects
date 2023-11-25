package com.example.retrofit.data.remote

import com.example.retrofit.data.model.Movie
import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
    @GET("movie")
    fun getMovies(): Call<List<Movie>>
}