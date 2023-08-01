package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.components.Components
import com.example.myapplication.ui.components.TextComponent
import com.example.myapplication.ui.components.TextFieldComponent

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Components.route)
    {
        composable(route = Screens.Components.route) {
            Components(navController = navController)
        }
        composable(route = Screens.Text.route) {
            TextComponent()
        }
        composable(route = Screens.TextField.route) {
            TextFieldComponent()
        }
    }
}