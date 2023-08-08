package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SimpleList() {
    val languages = listOf("Android", "IOS", "Kotlin", "Swift", "Ruby", "SwiftUI", "Combine")
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(languages) { language ->
            SimpleListItem(language = language)
        }
    }
}

@Composable 
fun SimpleListItem(language: String) {
    Text(text = language)
}