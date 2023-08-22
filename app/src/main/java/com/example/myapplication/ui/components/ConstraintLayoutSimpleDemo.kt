package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutSimpleDemo() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (textTopStart, textTopCenter, textTopEnd, textCenterStart,textCenter, textCenterEnd, textBottomStart, textBottomCenter, textBottomEnd) = createRefs()

        Text(text = "Top start", Modifier.constrainAs(textTopStart) {
            top.linkTo(parent.top, 8.dp)
            start.linkTo(parent.start, 8.dp)
        })

        Text(text = "Top Center", Modifier.constrainAs(textTopCenter) {
            top.linkTo(parent.top, 8.dp)
            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })

        Text(text = "Top end", Modifier.constrainAs(textTopEnd) {
            top.linkTo(parent.top, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })

        Text(text = "Center start", Modifier.constrainAs(textCenterStart) {
            top.linkTo(parent.top, 8.dp)
            bottom.linkTo(parent.bottom, 8.dp)
        })

        Text(text = "Center", Modifier.constrainAs(textCenter) {
            top.linkTo(parent.top, 8.dp)
            start.linkTo(parent.start, 8.dp)
            bottom.linkTo(parent.bottom, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })

        Text(text = "Center end", Modifier.constrainAs(textCenterEnd) {
            top.linkTo(parent.top, 8.dp)
            bottom.linkTo(parent.bottom, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })

        Text(text = "Bottom start", Modifier.constrainAs(textBottomStart) {
            bottom.linkTo(parent.bottom, 8.dp)
            start.linkTo(parent.start, 8.dp)
        })

        Text(text = "Bottom center", Modifier.constrainAs(textBottomCenter) {
            bottom.linkTo(parent.bottom, 8.dp)
            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })

        Text(text = "Bottom end", Modifier.constrainAs(textBottomEnd) {
            bottom.linkTo(parent.bottom, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })
    }
}