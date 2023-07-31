package com.example.myapplication.navigation

sealed class Screens(val route: String) {
    object Components: Screens("Components_Screen")
    object Text: Screens("Text_Screen")
}