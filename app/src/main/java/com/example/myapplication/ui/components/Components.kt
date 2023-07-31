package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.myapplication.navigation.Screens

@Composable
fun Components(navController: NavController) {
    Column {
        Button(onClick = { 
            navController.navigate(Screens.Text.route)
        }) {
            Text(text = "Text Component")
        }
    }
}