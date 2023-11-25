package com.example.retrofit.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.R
import com.example.retrofit.ui.viewModel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieViewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        movieViewModel.getMovies()

        movieViewModel.movie.observe(this) {
            Log.d("data", it.toString())
        }
    }
}