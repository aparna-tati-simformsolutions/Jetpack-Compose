package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutGuidelineAndChain() {
    Column {
        ConstraintLayoutGuideline()
        ConstraintLayoutChain()
    }
}

@Composable
fun ConstraintLayoutGuideline() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(12.dp)) {
        val (input) = createRefs()
        val guildLineFromTop = createGuidelineFromTop(0.5f)
        val guildLineFromStart = createGuidelineFromStart(50.dp)
        Text(
            text = "GuildLine From top and start",
            modifier = Modifier.constrainAs(input) {
                top.linkTo(guildLineFromTop)
                start.linkTo(guildLineFromStart)
            }
        )
    }
}

@Composable
fun ConstraintLayoutChain() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (button1, button2, button3) = createRefs()
        createHorizontalChain(button1, button2, button3, chainStyle = ChainStyle.SpreadInside)
        Button(onClick = { }, modifier = Modifier.constrainAs(button1) {
            centerHorizontallyTo(parent)
        }) {
            Text(text = "Button 1")
        }
        Button(onClick = { }, modifier = Modifier.constrainAs(button2) {
            centerVerticallyTo(parent)
        }) {
            Text(text = "Button 2")
        }
        Button(onClick = { }, modifier = Modifier.constrainAs(button3) {
            centerHorizontallyTo(parent)
        }) {
            Text(text = "Button 3")
        }
    }
}