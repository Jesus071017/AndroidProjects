package com.example.e_commerce.ui.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e_commerce.data.model.GeneralResponse
import com.example.e_commerce.data.model.User
import com.example.e_commerce.data.repository.UserRepository
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(application: Application) : AndroidViewModel(application) {
    val repository = UserRepository()
    val user = User()
    private val _profile = MutableLiveData<GeneralResponse>()
    val profile: LiveData<GeneralResponse>
        get() = _profile

    fun authLogin(email: String, password: String){
        user.email = email
        user.password = password

        Log.e("TAG", "Prueba: " + user.email + " : " + user.password)

        repository.authLogin(user).enqueue(object : Callback<GeneralResponse> {
            override fun onResponse(call: Call<GeneralResponse>, response: Response<GeneralResponse>){
                if(response.isSuccessful && response.body()?.response != null){
                    _profile.value = response.body()
                    Log.e("TAG", "Ok: " + response.body())
                }else{
                    val gson = Gson()
                    var resp = gson.fromJson(response.errorBody()?.string(), GeneralResponse::class.java)
                    Toast.makeText(getApplication(), resp.message, Toast.LENGTH_LONG).show()
                    _profile.value = resp
                    Log.e("TAG", "Error: " + resp.message)

                }
            }

            override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
                Log.e("TAG", "Error: " + t.message)
            }
        })
    }
}