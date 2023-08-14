package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Snackbar
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import kotlinx.coroutines.launch

@Composable
fun SwitchComponent() {
    Column {
        SimpleSwitch()
        CustomSwitch()
        SnackBarComponent()
    }
}

@Composable
fun SimpleSwitch() {
    val checkedState = remember { mutableStateOf(true) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}

@Composable
fun CustomSwitch() {
    val isToggle = remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(39.dp),
        elevation = 0.dp
    ) {
        Box(
            modifier = Modifier
                .background(if (isToggle.value) Color.Green else Color.Black)
                .clickable { isToggle.value = !isToggle.value },
            contentAlignment = Alignment.Center
        ) {
            if (isToggle.value) {
                Row(modifier = Modifier.padding(5.dp)) {
                    Text(
                        text = "On",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.W400),
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .align(CenterVertically)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_wifi_24),
                        contentDescription = "Wifi OFF",
                        tint = Color.White,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            } else {
                Row(modifier = Modifier.padding(5.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_wifi_off_24),
                        contentDescription = "Wifi OFF",
                        tint = Color.White,
                    )
                    Text(
                        text = "Off",
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.W400),
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                            .align(CenterVertically)
                    )
                }
            }
        }
    }
}

@Composable
fun SnackBarComponent() {
    Column {
        val (snackbarVisibleState, setSnackBarState) = remember { mutableStateOf(false) }
        val coroutineScope = rememberCoroutineScope()

        Button(onClick = { setSnackBarState(!snackbarVisibleState) }) {
            if (snackbarVisibleState) {
                Text("Hide Snackbar")
            } else {
                Text("Show Snackbar")
            }
        }
        if (snackbarVisibleState) {
            Snackbar(
                action = {
                    Button(onClick = {
                        coroutineScope.launch {
                            setSnackBarState(false)
                        }
                    }) {
                        Text("MyAction")
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "This is a snackbar!")
            }
        }
    }
}