package com.example.myapplication.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CardWithElevation()
        CardWithShape()
        CardWithBorder()
        CardWithMultipleViews()
        CardWithContentColor()
    }
}

@Composable
fun CardWithElevation() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(elevation = 10.dp, modifier = paddingModifier) {
        Text(text = "Simple Card With Elevation", modifier = paddingModifier)
    }
}

@Composable
fun CardWithShape() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(modifier = paddingModifier, shape = RoundedCornerShape(20.dp), elevation = 10.dp) {
        Text(text = "Simple Card With Shape", modifier = paddingModifier)
    }
}

@Composable
fun CardWithBorder() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(modifier = paddingModifier, elevation = 10.dp, border = BorderStroke(1.dp, Color.Blue)) {
        Text(text = "Simple Card With Border", modifier = paddingModifier)
    }
}

@Composable
fun CardWithMultipleViews() {
    val paddingModifier = Modifier.padding(10.dp)
    Card {
        Column(modifier = paddingModifier) {
            Text(text = "Text 1", modifier = paddingModifier)
            Text(text = "Text 2", modifier = paddingModifier)
        }
    }
}

@Composable
fun CardWithContentColor() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        elevation = 10.dp,
        contentColor = Color.Blue,
        modifier = paddingModifier
    ) {
        Column(modifier = paddingModifier) {
            Text(text = "Text 1", modifier = paddingModifier)
            Text(text = "Text 2", color = Color.Red, modifier = paddingModifier)
        }
    }
}




