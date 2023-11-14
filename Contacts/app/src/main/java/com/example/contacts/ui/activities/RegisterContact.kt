package com.example.contacts.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.ui.adapters.ContactAdapter
import com.example.contacts.ui.viewModels.ContactViewModel
import com.example.contacts.utils.Common

class RegisterContact : AppCompatActivity() {
    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_contact)

        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        val namesInput = findViewById<EditText>(R.id.namesReg)
        val lastNamesInput = findViewById<EditText>(R.id.lastNamesReg)
        val phoneInput = findViewById<EditText>(R.id.phoneReg)
        val emailInput = findViewById<EditText>(R.id.emailReg)
        val addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            if (Common.validateInput(
                this,
                namesInput.text.toString(),
                lastNamesInput.text.toString(),
                phoneInput.text.toString(),
                emailInput.text.toString()
            )){
                contactViewModel.saveContact(
                    namesInput.text.toString(),
                    lastNamesInput.text.toString(),
                    phoneInput.text.toString().toLong(),
                    emailInput.text.toString()
                )

                namesInput.setText("")
                lastNamesInput.setText("")
                phoneInput.setText("")
                emailInput.setText("")

                contactViewModel.getAllContacts()

                Common.showToast(this, R.string.successRegister)
            }
        }
    }
}