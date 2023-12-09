package com.example.e_commerce.ui.activity.shared

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.e_commerce.R
import com.example.e_commerce.ui.viewModel.UserViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var userViewModel: UserViewModel
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)

        editTextEmail = findViewById(R.id.username_sign_in)
        editTextPassword = findViewById(R.id.password_sign_in)
        btnLogin = findViewById(R.id.sign_in_button)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.profile.observe(this) { answer ->
            showAlert(answer.message.toString())
            if (answer.response != null) {
                val tokenS = answer.response["access_token"] as? String ?: ""

                saveLoginInfo(tokenS)

                val intent = Intent(this, ShowProduct::class.java)
                //intent.putExtra("image_path", imagePath)
                this.startActivity(intent)
            }
        }

        btnLogin.setOnClickListener {
            userViewModel.authLogin(editTextEmail.text.toString(), editTextPassword.text.toString())
        }
    }

    fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setPositiveButton("Ok") { dialog, which ->
            // Acción al hacer clic en el botón "Aceptar"
            // Puedes colocar código aquí para manejar la acción del botón
        }
        builder.setMessage(message)
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    private fun saveLoginInfo(token: String) {
        // Guardar el nombre de usuario en SharedPreferences para recordar el inicio de sesión
        val editor = sharedPreferences.edit()
        editor.putString("access_token", token)
        editor.putString("refresh_token", token)
        editor.apply()
    }


}