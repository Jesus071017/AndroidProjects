package com.example.e_commerce.data.model

import java.time.LocalDate

data class Product (
    val created_at: String,
    val id: Int,
    val image: String,
    val name: String,
    val product_type: Int,
    val stock: Int,
    val updated_at: LocalDate,
    val value: Int
)