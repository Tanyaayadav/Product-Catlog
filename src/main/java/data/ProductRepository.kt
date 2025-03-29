

package com.example.productcatalogapp.data

class ProductRepository(private val apiService: ProductApiService) {
    suspend fun getProducts(): List<Product> = apiService.getProducts().products  // ✅ Extracts the product list
    suspend fun getProductDetails(id: Int): Product = apiService.getProductDetails(id)
}

