package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.ui.components.ButtonComponent
import com.example.myapplication.ui.components.Components
import com.example.myapplication.ui.components.CustomList
import com.example.myapplication.ui.components.Layouts
import com.example.myapplication.ui.components.ListComponent
import com.example.myapplication.ui.components.Modifiers
import com.example.myapplication.ui.components.SimpleGrid
import com.example.myapplication.ui.components.SimpleList
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
        composable(route = Screens.Button.route) {
            ButtonComponent()
        }
        composable(route = Screens.Layouts.route) {
            Layouts()
        }
        composable(route = Screens.Modifiers.route) {
            Modifiers()
        }
        composable(route = Screens.List.route) {
            ListComponent(navController)
        }
        composable(route = Screens.SimpleList.route) {
            SimpleList()
        }
        composable(route = Screens.CustomList.route) {
            CustomList()
        }
        composable(route = Screens.SimpleGrid.route) {
            SimpleGrid()
        }
    }
}