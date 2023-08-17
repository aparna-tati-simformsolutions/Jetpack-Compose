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
fun SelectionComponents(navController: NavController) {
    val buttonList = listOf(
        ButtonData(text = "CheckBox Component", route = Screens.CheckBox.route),
        ButtonData(text = "RadioButton Component", route = Screens.RadioButton.route),
        ButtonData(text = "Slider Component", route = Screens.Slider.route),
        ButtonData(text = "Switch Component", route = Screens.Switch.route),
        ButtonData(text = "DropDown Component", route = Screens.Dropdown.route),
        ButtonData(text = "Dialog Component", route = Screens.Dialog.route),
        ButtonData(text = "Progress Indicators", route = Screens.ProgressIndicators.route)
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