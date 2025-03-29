package com.example.productcatalogapp.data

import com.google.gson.annotations.SerializedName

data class Product(
    val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Double,
    val rating: Float? = null,
    @SerializedName("category") val category: String,
    @SerializedName("images") val images: List<String>,
    @SerializedName("thumbnail") val imageUrl: String,
    val availabilityStatus: String,
    val warrantyInformation: String
)

data class ProductResponse(
    @SerializedName("products") val products: List<Product>
)
