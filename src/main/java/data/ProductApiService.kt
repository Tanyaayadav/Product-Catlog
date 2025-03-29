

package com.example.productcatalogapp.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("products/{id}")
    suspend fun getProductDetails(@Path("id") id: Int): Product
}

