package com.example.productcatalogapp.data

import com.google.gson.annotations.SerializedName

data class ProductsWrapper(
    @SerializedName("products") val products: List<Product>
)
