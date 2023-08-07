package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Layouts() {
    Column {
        RowLayout()
        RowLayoutWithArrangements()
        ColumnLayout()
        ColumnLayoutWithArrangement()
    }
}

@Composable
fun RowLayout() {
    Row {
        Text(text = "Row 1")
        Text(text = "Row 2")
        Text(text = "Row 3")
    }
}

@Composable
fun RowLayoutWithArrangements() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Row 1")
        Text(text = "Row 2")
        Text(text = "Row 3")
    }
}
@Composable
fun ColumnLayout() {
    Column {
        Text(text = "Column 1")
        Text(text = "Column 2")
        Text(text = "Column 3")
    }
}

@Composable
fun  ColumnLayoutWithArrangement() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Column 1")
        Text(text = "Column 2")
        Text(text = "Column 3")
    }
}

