package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.model.ButtonData
import com.example.myapplication.navigation.Screens

@Composable
fun ListComponent(navController: NavController) {
    val buttonList = listOf(
        ButtonData(text = "Simple List", route = Screens.SimpleList.route),
        ButtonData(text = "Custom List", route = Screens.CustomList.route)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        buttonList.forEach { buttonData ->
            ButtonView(navController = navController, buttonData = buttonData)
        }
    }
}