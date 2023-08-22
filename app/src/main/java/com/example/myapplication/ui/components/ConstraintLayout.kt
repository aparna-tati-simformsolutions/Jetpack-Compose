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
fun ConstraintLayoutDemo(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate(Screens.ConstraintLayoutSimpleDemo.route)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Simple Demo")
        }
        Button(onClick = {

        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login Demo")
        }
        Button(onClick = {

        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Chains Demo")
        }
        Button(onClick = {

        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Barrier Demo")
        }
    }
}