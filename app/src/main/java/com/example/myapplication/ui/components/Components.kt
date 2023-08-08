package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.navigation.Screens

@Composable
fun Components(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { 
            navController.navigate(Screens.Text.route)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Text Component")
        }
        
        Button(onClick = {
            navController.navigate(Screens.TextField.route)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "TextField Component")
        }
        
        Button(onClick = {
            navController.navigate(Screens.Button.route)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Button Component")
        }
        
        Button(onClick = {
            navController.navigate(Screens.Layouts.route)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Layouts")
        }

        Button(onClick = {
            navController.navigate(Screens.Modifiers.route)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Modifiers")
        }

        Button(onClick = {
            navController.navigate(Screens.List.route)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "List")
        }
    }
}