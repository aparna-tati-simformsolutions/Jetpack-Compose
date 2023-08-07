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
        
        Button(onClick = {
            navController.navigate(Screens.TextField.route)
        }) {
            Text(text = "TextField Component")
        }
        
        Button(onClick = {
            navController.navigate(Screens.Button.route)
        }) {
            Text(text = "Button Component")
        }
        
        Button(onClick = {
            navController.navigate(Screens.Layouts.route)
        }) {
            Text(text = "Layouts")
        }
    }
}