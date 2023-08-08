package com.example.myapplication.navigation

sealed class Screens(val route: String) {
    object Components: Screens("Components_Screen")
    object Text: Screens("Text_Screen")
    object TextField: Screens("Textfield_Screen")
    object Button: Screens("Button_Screen")
    object Layouts: Screens("Layout_Screen")
    object Modifiers: Screens("Modifier_Screen")
    object List: Screens("List_Screen")
    object SimpleList: Screens("Simple_List_Screen")
    object CustomList: Screens("Custom_List_Screen")
}