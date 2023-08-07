package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Modifiers() {
    Column(Modifier.background(Color.Gray)) {
        ModifierDemo1()
    }
}

@Composable
fun ModifierDemo1() {
    Column(modifier = Modifier.padding(24.dp)) {
        Text(text = "Hello ")
        Text(text = "World")
    }
}
