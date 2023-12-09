package com.example.e_commerce.ui.activity.shared

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import androidx.lifecycle.ViewModelProvider
import com.example.e_commerce.R
import com.example.e_commerce.data.model.Product
import com.example.e_commerce.ui.viewModel.ProductViewModel

class ShowProduct : AppCompatActivity() {
    val OFFSET = 1
    private lateinit var productViewModel: ProductViewModel
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_product)
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productViewModel.profile.observe(this){answer ->
            if(answer.response != null){
                val arrayAny = arrayOf(answer.response)
                val productList: List<Product> = arrayAny.mapNotNull { it as? Product }

                showProducts(productList)
            }else{
                showAlert(answer.message.toString())
            }
        }
        getProducts()
    }

    fun getProducts(){
        val token = sharedPreferences.getString("access_token", "")
        productViewModel.getProducts(OFFSET, token)
    }

    fun showProducts(products: List<Product>){
        val gridView: GridView = findViewById(R.id.gridView)
        val adapter = GridAdapter(this, products)

        gridView.adapter = adapter
    }
    fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setPositiveButton("Ok") { dialog, which ->
            // Acción al hacer clic en el botón "Aceptar"
            // Puedes colocar código aquí para manejar la acción del botón
        }
        builder.setMessage(message)
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}