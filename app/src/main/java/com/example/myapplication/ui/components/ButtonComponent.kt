package com.example.myapplication.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun ButtonComponent() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SimpleButton()
        ButtonWithColor()
        ButtonWithTwoTexts()
        ButtonWithIcon()
        ButtonWithRectangleShape()
        ButtonWithRoundedShape()
        ButtonWithCutCornerShape()
        ButtonWithBorder()
        ButtonWithElevation()
        SimpleOutlinedButton()
        OutlinedButtonWithColors()
        OutlinedButtonWithBorderColor()
        OutlinedButtonWithShape()
        SimpleTextButton()
        TextButtonWithColors()
        TextButtonWithShapeAndBorder()
        SimpleIconButton()
        IconButtonWithSize()
        IconButtonWithText()
    }
}

@Composable
fun SimpleButton() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Simple Button")
    }
}

@Composable
fun ButtonWithColor() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
    ) {
        Text(text = "Simple Button", color = Color.White)
    }
}

@Composable
fun ButtonWithTwoTexts() {
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Simple", color = Color.LightGray)
        Text(text = " Button", color = Color.Yellow)
    }
}

@Composable
fun ButtonWithIcon() {
    Button(onClick = { /*TODO*/ }) {
        Image(
            painter = painterResource(id = R.drawable.baseline_shopping_cart_24), 
            contentDescription = "cartIcon", 
            modifier = Modifier.size(20.dp)
        )
        Text(text = "Add to cart", modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
fun ButtonWithRectangleShape() {
    Button(onClick = { /*TODO*/ }, shape = RectangleShape) {
        Text(text = "Rectangle Shape")
    }
}

@Composable
fun ButtonWithRoundedShape() {
    Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(20.dp)) {
        Text(text = "Rounded Shape")
    }
}

@Composable
fun ButtonWithCutCornerShape() {
    Button(onClick = { /*TODO*/ }, shape = CutCornerShape(20)) {
        Text(text = "Cut Corner Shape")
    }
}

@Composable
fun ButtonWithBorder() {
    Button(
        onClick = { /*TODO*/ },
        border = BorderStroke(width = 1.dp, color = Color.Red),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
    ) {
        Text(text = "Button with border", color = Color.DarkGray)
    }
}

@Composable
fun ButtonWithElevation() {
    Button(
        onClick = { /*TODO*/ }, 
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp, 
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )) {
        Text(text = "Button with elevation")
    }
}

@Composable
fun SimpleOutlinedButton() {
    val context = LocalContext.current.applicationContext
    OutlinedButton(
        onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.size(width = 160.dp, height = 50.dp)
    ) {
        Text(text = "Simple Outlined")
    }
}

@Composable
fun OutlinedButtonWithColors() {
    val context = LocalContext.current.applicationContext
    OutlinedButton(
        onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Yellow
        )
    ) {
        Text(text = "Outlined with colors")
    }
}

@Composable
fun OutlinedButtonWithBorderColor() {
    val context = LocalContext.current.applicationContext
    OutlinedButton(
        onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
        },
        border = BorderStroke(1.dp, Color.Red)
    ) {
        Text(text = "Outlined with colors")
    }
}

@Composable
fun OutlinedButtonWithShape() {
    val context = LocalContext.current.applicationContext
    OutlinedButton(
        onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
        },
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = "Outlined with shape")
    }
}

@Composable
fun SimpleTextButton() {
    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "Simple Text Button")
    }
}

@Composable
fun TextButtonWithColors() {
    TextButton(onClick = { /*TODO*/ }, colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Green.copy(alpha = 0.5f)
    )) {
        Text(text = "Simple Text Button")
    }
}

@Composable
fun TextButtonWithShapeAndBorder() {
    TextButton(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(percent = 15),
        border = BorderStroke(width = 2.dp, color = Color.Green)
    ) {
        Text(text = "Simple Text Button")
    }
}

@Composable
fun SimpleIconButton() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Outlined.ThumbUp, contentDescription = "ThumbsUp")
    }
}

@Composable
fun IconButtonWithSize() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Outlined.ThumbUp,
            contentDescription = "ThumbsUp",
            modifier = Modifier.size(50.dp),
            tint = Color.Green
        )
    }
}

@Composable
fun IconButtonWithText() {
    IconButton(onClick = { /*TODO*/ }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.ThumbUp,
                contentDescription = "ThumbsUp"
            )
            Spacer(modifier = Modifier.width(width = 8.dp))
            Text(text = "Like")
        }
    }
}