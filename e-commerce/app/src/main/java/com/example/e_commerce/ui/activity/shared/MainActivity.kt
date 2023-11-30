package com.example.e_commerce.ui.activity.shared

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.e_commerce.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUpButton = findViewById<Button>(R.id.sign_up_button)

        signUpButton.setOnClickListener {
            val intent = Intent(this, RegisterCustomer::class.java)
            startActivity(intent)
        }
    }
}