package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Colors
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProgressIndicatorComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearIndeterminateProgressIndicator()
        CircularIndeterminateProgressIndicator()
        LinearDeterminateProgressIndicator()
        CircularDeterminateProgressIndicator()
        CustomLinearProgressIndicator()
        CustomCircularProgressIndicator()
    }
}

@Composable
fun LinearIndeterminateProgressIndicator() {
    Column {
        Text(text = "Linear Indeterminate Progress Indicator")
        LinearProgressIndicator()
    }
}

@Composable
fun CircularIndeterminateProgressIndicator() {
    Column {
        Text(text = "Circular Indeterminate Progress Indicator")
        CircularProgressIndicator()
    }
}

@Composable
fun LinearDeterminateProgressIndicator() {
    Column {
        Text(text = "Linear Determinate Progress Indicator")
        LinearProgressIndicator(progress = 0.7f)
    }
}

@Composable
fun CircularDeterminateProgressIndicator() {
    Column {
        Text(text = "Linear Determinate Progress Indicator")
        CircularProgressIndicator(progress = 0.7f)
    }
}

@Composable
fun CustomLinearProgressIndicator() {
    Column {
        Text(text = "Custom Linear Progress Indicator")
        LinearProgressIndicator(
            modifier = Modifier
                .height(10.dp),
            backgroundColor = Color.Gray,
            color = Color.Red,
        )
    }
}

@Composable
fun CustomCircularProgressIndicator() {
    Column {
        Text(text = "Custom Linear Progress Indicator")
        CircularProgressIndicator(
            modifier = Modifier
                .height(10.dp),
            color = Color.Green,
            strokeWidth = 5.dp
        )
    }
}

