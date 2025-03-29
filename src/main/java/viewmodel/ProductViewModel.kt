package com.example.productcatalogapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.productcatalogapp.data.Product
import com.example.productcatalogapp.data.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products

    private val _productDetails = MutableStateFlow<Product?>(null)
    val productDetails: StateFlow<Product?> get() = _productDetails

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                Log.d("ProductViewModel", "Fetching products...")

                val productList = repository.getProducts()  // ✅ Returns List<Product>

                Log.d("ProductViewModel", "Products fetched: ${productList.size} items")
                _products.value = productList

            } catch (e: IOException) {
                Log.e("ProductViewModel", "Network Error: No internet or server unreachable - ${e.localizedMessage}")
            } catch (e: HttpException) {
                Log.e("ProductViewModel", "HTTP Exception: ${e.message()}")
            } catch (e: Exception) {
                Log.e("ProductViewModel", "Unexpected Error: ${e.localizedMessage}")
            }
        }
    }

    fun fetchProductDetails(productId: Int) {
        viewModelScope.launch {
            try {
                Log.d("ProductViewModel", "Fetching details for Product ID: $productId")
                val product = repository.getProductDetails(productId)

                Log.d("ProductViewModel", "Fetched Product: $product")
                Log.d("ProductViewModel", "Product Images: ${product.images}")  

                _productDetails.value = product
            } catch (e: Exception) {
                Log.e("ProductViewModel", "Error fetching product details: ${e.localizedMessage}")
            }
        }
    }

}

class ProductViewModelFactory(private val repository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}






