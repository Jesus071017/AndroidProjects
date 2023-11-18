package com.example.projecttestone

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var getContent: ActivityResultLauncher<String>
    private var myUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById<ImageView>(R.id.image)
        val selectImageButton = findViewById<Button>(R.id.button)
        val shareImageButton = findViewById<Button>(R.id.button2)

        getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {uri: Uri? ->
            uri?.let {
                imageView.setImageURI(it)
                myUri = it
            }
        }

        selectImageButton.setOnClickListener{
            pickImageFromGallery()
        }

        shareImageButton.setOnClickListener {
            shareImage()
        }
    }

    private fun pickImageFromGallery(){
        getContent.launch("image/*")
    }

    private fun shareImage(){
        if (myUri != null) {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "image/*"
            shareIntent.putExtra(Intent.EXTRA_STREAM, myUri)
            startActivity(Intent.createChooser(shareIntent, "Share image"))
        }
        else {
            Toast.makeText(this, "Please, pick an image.", Toast.LENGTH_SHORT).show()
        }
    }
}