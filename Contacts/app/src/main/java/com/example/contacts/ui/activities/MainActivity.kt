package com.example.contacts.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.R
import com.example.contacts.ui.adapters.ContactAdapter
import com.example.contacts.ui.viewModels.ContactViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var contactViewModel: ContactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        contactViewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        contactViewModel.getAllContacts()

        contactViewModel.contacts.observe(this) {contacts ->
            val recyclerView = findViewById<RecyclerView>(R.id.item_recycle)
            val adapter = ContactAdapter(contacts)

            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter
        }

        val search = findViewById<EditText>(R.id.search)
        val addButton = findViewById<Button>(R.id.button)
        val updButton = adapter.findViewById<Button>(R.id.card_view)

        addButton.setOnClickListener {
            val intent = Intent(this, RegisterContact::class.java)
            startActivity(intent)
        }

        updButton.setOnClickListener {
            val intent = Intent(this, UpdateContact::class.java)
            startActivity(intent)
        }
    }
}