package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent() {
    val text = "Hello Android!!"

    Column {
        SimpleText(text = text)
        TextColorProperty(text = text, color = Color.Blue)
        TextSizeProperty(text = text, size = 30.sp)
        TextFontStyleProperty(text = text)
        TextFontWeightProperty(text = text)
        TextShadow(text = text)
        TextWithMultipleStyle()
        TextWithFontFamily(text = text)
        TextUnderlineProperty(text = text)
        TextLineThroughProperty(text = text)
    }
}

@Composable
fun SimpleText(text: String) {
    Text(text = text)
}

@Composable
fun TextColorProperty(text: String, color: Color) {
    Text(text = text, color = color)
}

@Composable
fun TextSizeProperty(text: String, size: TextUnit) {
    Text(text = text, fontSize = size)
}

@Composable
fun TextFontStyleProperty(text: String) {
    Text(text = text, fontStyle = FontStyle.Italic)
}

@Composable
fun TextFontWeightProperty(text: String) {
    Text(text = text, fontWeight = FontWeight.Bold)
}

@Composable
fun TextShadow(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 20.sp,
            shadow = Shadow(
                color = Color.Blue,
                offset = Offset(x = 5.0f, y = 10.0f),
                blurRadius = 5f
            )
        )
    )
}

@Composable
fun TextWithMultipleStyle() {
    Text(text =
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                append('H')
            }
            append("ello ")

            withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Bold)) {
                append('W')
            }
            append("orld!")
        },
        fontSize = 30.sp
    )
}

@Composable
fun TextWithFontFamily(text: String) {
    Text(text = text, fontFamily = FontFamily.Cursive)
}

@Composable
fun TextUnderlineProperty(text: String) {
    Text(text = text, style = TextStyle(textDecoration = TextDecoration.Underline))
}

@Composable
fun TextLineThroughProperty(text: String) {
    Text(text = text, style = TextStyle(textDecoration = TextDecoration.LineThrough))
}