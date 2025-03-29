
package com.example.productcatalogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.productcatalogapp.data.Product
import com.example.productcatalogapp.data.ProductApiService
import com.example.productcatalogapp.data.ProductRepository
import com.example.productcatalogapp.ui.ProductDetailScreen
import com.example.productcatalogapp.ui.ProductListScreenWithToolbar
import com.example.productcatalogapp.ui.theme.ProductCatalogAppTheme
import com.example.productcatalogapp.viewmodel.ProductViewModel
import com.example.productcatalogapp.viewmodel.ProductViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier

@Composable
fun AppNavigation(viewModel: ProductViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "productList") {
        composable("productList") {
            ProductListScreenWithToolbar(navController, viewModel)
        }
        composable("productDetail/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            ProductDetailScreen(id, viewModel)
        }
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductCatalogAppTheme {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://dummyjson.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ProductApiService::class.java)

                val repository = ProductRepository(retrofit)
                val viewModel: ProductViewModel = viewModel(factory = ProductViewModelFactory(repository))

                AppNavigation(viewModel)
            }
        }
    }
}

