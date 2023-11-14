package com.example.contacts.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "names") val names: String,
    @ColumnInfo(name = "last_names") val lastNames: String,
    @ColumnInfo(name = "phone") val phone: Long,
    @ColumnInfo(name = "email") val email: String,
)
