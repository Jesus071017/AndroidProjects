package com.example.contacts.data.bd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.contacts.data.models.Contact

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    fun getAllContacts(): List<Contact>

    @Insert
    fun insertContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)
}