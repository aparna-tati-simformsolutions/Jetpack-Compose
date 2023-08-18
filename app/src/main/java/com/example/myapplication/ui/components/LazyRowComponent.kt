package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LazyRowComponent() {
    val lists = listOf("Apple", "Banana", "Mango", "Graps", "Apple", "Banana", "Mango", "Graps")

    LazyRow {
        items(lists) { list ->
            Card(
                elevation = 10.dp,
                modifier = Modifier.size(width = 150.dp, height = 100.dp).padding(10.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize().background(Color.Gray.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = list)
                }
            }
        }
    }
}