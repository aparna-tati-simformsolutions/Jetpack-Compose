package com.example.myapplication.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

val constraintSet = ConstraintSet {
    val buttonLogin = createRefFor("buttonLogin")
    val inputUsername = createRefFor("inputUsername")
    val inputPassword = createRefFor("inputPassword")
    constrain(inputUsername) {
        top.linkTo(parent.top, 32.dp)
        start.linkTo(parent.start, 16.dp)
        end.linkTo(parent.end, 16.dp)
    }
    constrain(inputPassword) {
        top.linkTo(inputUsername.bottom, 8.dp)
        start.linkTo(parent.start, 16.dp)
        end.linkTo(parent.end, 16.dp)
    }
    constrain(buttonLogin) {
        top.linkTo(inputPassword.bottom, 16.dp)
        start.linkTo(parent.start, 16.dp)
        end.linkTo(parent.end, 16.dp)
    }
}

@Composable
fun LoginScreenUsingConstraintLayout() {
    ConstraintLayout(
        constraintSet, modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)) {
        val context = LocalContext.current
        val username = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }
        TextField(
            value = username.value,
            onValueChange = { username.value = it } ,
            label = { Text(text = ("Username"))},
            modifier =  Modifier.layoutId("inputUsername")
        )
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password")},
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.layoutId("inputPassword")
        )
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Username ${username.value} , Password: ${password.value} ",
                    Toast.LENGTH_SHORT
                ).show() },
            Modifier.layoutId("buttonLogin")
        ) {
            Text(text = "Login")
        }
    }
}