package com.example.contacts.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.contacts.data.models.Contact
import com.example.contacts.data.repository.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel(application: Application): AndroidViewModel(application) {

    private val contactRepository = ContactRepository(application)

    private val _contacts = MutableLiveData<List<Contact>>()
    val contacts: LiveData<List<Contact>>
        get() = _contacts

    fun saveContact(
        names: String,
        lastNames: String,
        phone: Long,
        email: String
    ){
        viewModelScope.launch {
            contactRepository.saveContact(
                names,
                lastNames,
                phone,
                email
            )
        }
    }

    fun updateContact(
        id: Long,
        names: String,
        lastNames: String,
        phone: Long,
        email: String
    ){
        viewModelScope.launch {
            contactRepository.updateContact(
                id,
                names,
                lastNames,
                phone,
                email
            )
        }
    }

    fun getAllContacts(){
        viewModelScope.launch {
            _contacts.value = contactRepository.getAllContacts()
        }
    }
}