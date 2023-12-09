package com.example.e_commerce.ui.activity.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.e_commerce.R

class CreateCustomer : AppCompatActivity() {
    private lateinit var editTextNames: EditText
    private lateinit var editTextLastnames: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var editTextCiy: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var btnSignUp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_customer)


    }
}