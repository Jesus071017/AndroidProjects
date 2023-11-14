package com.example.contacts.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.contacts.R
import com.example.contacts.ui.viewModels.ContactViewModel
import com.example.contacts.utils.Common

class UpdateContact : AppCompatActivity() {
    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_contact)

        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        val namesInput = findViewById<EditText>(R.id.namesUpd)
        val lastNamesInput = findViewById<EditText>(R.id.lastNamesUpd)
        val phoneInput = findViewById<EditText>(R.id.phoneUpd)
        val emailInput = findViewById<EditText>(R.id.emailUpd)
        val updButton = findViewById<Button>(R.id.updButton)

        var id: Long = 0
        val names = namesInput.text.toString()
        val lastNames = lastNamesInput.text.toString()
        val phone = phoneInput.text.toString()
        val email = emailInput.text.toString()

        intent.getStringExtra("id")?.let{
             id = it.toString().toLong()
        }

        intent.getStringExtra("names")?.let{
            namesInput.setText(it)
        }

        intent.getStringExtra("lastNames")?.let{
            lastNamesInput.setText(it)
        }

        intent.getStringExtra("phone")?.let{
            phoneInput.setText(it)
        }

        intent.getStringExtra("email")?.let{
            emailInput.setText(it)
        }

        updButton.setOnClickListener {
            if (Common.validateInput(
                this,
                names,
                lastNames,
                phone,
                email
            )){
                contactViewModel.updateContact(
                    id,
                    names,
                    lastNames,
                    phone.toLong(),
                    email
                )

                Common.showToast(this, R.string.successUpdate)
            }
        }
    }
}