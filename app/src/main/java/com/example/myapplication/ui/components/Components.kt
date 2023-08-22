package com.example.myapplication.ui.components

import  androidx.compose.foundation.layout.Arrangement
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
import com.example.myapplication.model.ButtonData
import com.example.myapplication.navigation.Screens

@Composable
fun Components(navController: NavController) {
    val buttonList = listOf(
        ButtonData(text = "Text Component", route = Screens.Text.route),
        ButtonData(text = "TextField Component", route = Screens.TextField.route),
        ButtonData(text = "Button Component", route = Screens.Button.route),
        ButtonData(text = "Layouts", route = Screens.Layouts.route),
        ButtonData(text = "Modifiers", route = Screens.Modifiers.route),
        ButtonData(text = "List Component", route = Screens.List.route),
        ButtonData(text = "Grid Component", route = Screens.SimpleGrid.route),
        ButtonData(text = "Scaffold Component", route = Screens.Scaffold.route),
        ButtonData(text = "Card Component", route = Screens.Card.route),
        ButtonData(text = "Selection Component", route = Screens.SelectionComponent.route),
        ButtonData(text = "Lazy Component", route = Screens.Lazy.route)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        buttonList.forEach { buttonData ->  
            ButtonView(navController = navController, buttonData = buttonData)
        }
    }
}

@Composable
fun ButtonView(navController: NavController, buttonData: ButtonData) {
    Button(onClick = {
        navController.navigate(buttonData.route)
    }, modifier = Modifier.fillMaxWidth()) {
        Text(text = buttonData.text)
    }
}