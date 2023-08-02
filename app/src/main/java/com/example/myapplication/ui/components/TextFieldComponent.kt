package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldComponent() {
    Column {
        TextFieldAlignment()
        MultilineTextField()
        GradientTextField()
        SimpleTextField()
        TextFieldWithLabelAndPlaceholder()
        TextFieldWithKeyboardOptions()
        TextFieldWithOutline()
        TextFieldWithIcons()
        PasswordTextField()
        TextFieldWithValidation()
        TextFieldWithMaxLengthProperty()
    }
}

@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
    )
}

@Composable
fun TextFieldWithLabelAndPlaceholder() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = "Your Label") },
        placeholder = { Text(text = "Your Placeholder") }
    )
}

@Composable
fun TextFieldWithKeyboardOptions() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        label = { Text(text = "Enter Number") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun TextFieldWithOutline() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter your name") },
        onValueChange = { text = it },
        enabled = false
    )
}

@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf("") }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon")},
        onValueChange = { text = it },
        label = { Text(text = "Email Address") }, 
        placeholder = { Text(text = "Enter your e-mail") },
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words, imeAction = ImeAction.Search)
    )
}

@Composable
fun PasswordTextField() {
    var text by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = "Password") },
        placeholder = { Text(text = "Enter your password") },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Lock, contentDescription = "LockIcon")
        },
        trailingIcon = {
            IconButton(onClick = { showPassword = !showPassword }) {
                Icon(
                    imageVector = if (showPassword) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = if (showPassword) "Show Password" else "Hide Password"
                )
            }
        },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun TextFieldWithValidation() {
    var text by remember { mutableStateOf("") }
    var isUserBelow18 by remember { mutableStateOf(false) }

    Column {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text(text = "Age") },
            placeholder = { Text(text = "Enter your age") },
            isError = isUserBelow18,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    if (text.isNotEmpty()) {
                        isUserBelow18 = validateAge(inputText = text)
                    }
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Cyan.copy(alpha = 0.4f),
                cursorColor = Color.Yellow
            )
        )

        if (isUserBelow18) {
            Text(text = "You should be 18+", color = Color.Red)
        }
    }
}

private fun validateAge(inputText: String): Boolean {
    return inputText.toInt() < 18
}

@Composable
fun TextFieldWithMaxLengthProperty() {
    var text by remember { mutableStateOf("") }
    val maxLength = 5

    TextField(
        value = text,
        onValueChange = { newText ->
            if (newText.length <= maxLength) {
                text = newText
            }
        }
    )
}

@Composable
fun GradientTextField() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.background(
            brush = Brush.horizontalGradient(listOf(Color.Green, Color.Yellow))
        )
    )
}

@Composable
fun MultilineTextField() {
    var text by remember { mutableStateOf("") }
    
    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.padding(horizontal = 8.dp),
        singleLine = false
    )
}

@Composable
fun TextFieldAlignment() {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
    )
}