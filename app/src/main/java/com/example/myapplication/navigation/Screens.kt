package com.example.myapplication.navigation

sealed class Screens(val route: String) {
    object Components: Screens("Components_Screen")
    object Text: Screens("Text_Screen")
    object TextField: Screens("Textfield_Screen")
    object Button: Screens("Button_Screen")

    object Layouts: Screens("Layout_screen")
}