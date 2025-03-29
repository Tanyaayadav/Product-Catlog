
package com.example.productcatalogapp.ui

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.productcatalogapp.viewmodel.ProductViewModel

@Composable
fun ProductDetailScreen(productId: Int, viewModel: ProductViewModel) {
    val product by viewModel.productDetails.collectAsState()

    LaunchedEffect(productId) {
        viewModel.fetchProductDetails(productId)
        Log.d("ProductDetailScreen", "Fetching product details for ID: $productId")
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF3E0))
            .padding(16.dp)
    ) {
        AnimatedVisibility(visible = product != null) {
            product?.let {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    // Product Image
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(6.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        AsyncImage(
                            model = it.images.firstOrNull(),
                            contentDescription = "Product Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))


                    Text(text = it.title, fontSize = 24.sp, style = MaterialTheme.typography.headlineSmall)
                    Text(text = "⭐ Rating: ${it.rating} / 5", fontSize = 18.sp, color = MaterialTheme.colorScheme.secondary)
                    Text(text = "📂 Category: ${it.category}", fontSize = 16.sp)

                    // Price Box
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "💰 Price: \$${it.price}",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Text(text = "🔄 Stock Status: ${it.availabilityStatus ?: "Not Available"}")
                    Text(text = "🛡 Warranty: ${it.warrantyInformation ?: "No Warranty Info"}")
                    Spacer(modifier = Modifier.height(8.dp))

                    // Description
                    Text(
                        text = it.description,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

        FloatingActionButton(
            onClick = { /* Handle Buy Now */ },
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(androidx.compose.ui.Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Buy Now")
        }
    }
}






