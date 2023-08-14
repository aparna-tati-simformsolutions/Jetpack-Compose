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
    object SimpleGrid: Screens("Simple_Grid_Screen")
    object Scaffold: Screens("Scaffold_Screen")
    object Card: Screens("Card_Screen")
    object SelectionComponent: Screens("Selection_Components_Screen")
    object CheckBox: Screens("Check_Box_Screen")
    object RadioButton: Screens("Radio_Button_Screen")
    object Slider: Screens("Slider_Screen")
    object Switch: Screens("Switch_Screen")
}