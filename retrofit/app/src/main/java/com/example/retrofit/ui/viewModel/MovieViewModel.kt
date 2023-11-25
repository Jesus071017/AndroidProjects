package com.example.retrofit.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.data.model.Movie
import com.example.retrofit.data.repository.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(application: Application): AndroidViewModel(application) {
    val repository = MovieRepository()

    private val _movieList = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>>
        get() = _movieList

    fun getMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getMovies().execute()

            _movieList.postValue(response.body())
        }
    }
}
