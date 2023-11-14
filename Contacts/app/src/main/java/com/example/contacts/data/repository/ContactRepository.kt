package com.example.contacts.data.repository

import android.content.Context
import com.example.contacts.data.bd.AppDatabase
import com.example.contacts.data.models.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactRepository(context: Context) {
    private val database = AppDatabase.getInstance(context)

    suspend fun saveContact(
        names: String,
        lastNames: String,
        phone: Long,
        email: String
    ){
        withContext(Dispatchers.IO) {
            database.contactDao().insertContact(Contact(
                names = names,
                lastNames = lastNames,
                phone = phone,
                email = email
            ))
        }
    }

    suspend fun updateContact(
        id: Long,
        names: String,
        lastNames: String,
        phone: Long,
        email: String
    ){
        withContext(Dispatchers.IO) {
            database.contactDao().updateContact(Contact(
                id = id,
                names = names,
                lastNames = lastNames,
                phone = phone,
                email = email
            ))
        }
    }

    suspend fun getAllContacts(): List<Contact> {
        return withContext(Dispatchers.IO) {
            database.contactDao().getAllContacts()
        }
    }
}