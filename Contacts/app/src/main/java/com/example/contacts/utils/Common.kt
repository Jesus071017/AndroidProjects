package com.example.contacts.utils

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import com.example.contacts.R

class Common {

    companion object {
        fun showToast(context: Context, message: Int, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(context, message, duration).show()
        }

        fun validateInput(
            context: Context,
            names: String,
            lastNames: String,
            phone: String,
            email: String
        ): Boolean{
            var validation = false

            if (names.isEmpty()){
                Common.showToast(context, R.string.namesRequired)
            }
            else if (lastNames.isEmpty()){
                Common.showToast(context, R.string.lastNamesRequired)
            }
            else if (phone.isEmpty()){
                Common.showToast(context, R.string.phoneRequired)
            }
            else if (email.isEmpty()){
                Common.showToast(context, R.string.emailRequired)
            }
            else if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())){
                Common.showToast(context, R.string.badEmail)
            }
            else {
                validation = true
            }

            return validation
        }
    }
}
