package com.example.contacts.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.data.models.Contact
import com.example.contacts.R

class ContactAdapter(private val contacts: List<Contact>): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemNames.text = "${contacts[position].names} ${contacts[position].lastNames}"
        viewHolder.itemPhone.text = contacts[position].phone.toString()
        viewHolder.itemEmail.text = contacts[position].email
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemNames: TextView
        var itemPhone: TextView
        var itemEmail: TextView

        init {
            itemNames = itemView.findViewById(R.id.itemNames)
            itemPhone = itemView.findViewById(R.id.itemPhone)
            itemEmail = itemView.findViewById(R.id.itemEmail)
        }
    }
}