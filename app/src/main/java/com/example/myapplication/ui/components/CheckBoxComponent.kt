package com.example.myapplication.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckBoxComponent() {
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()
    ) {
        SimpleCheckBox()
        CheckBoxWithTitle()
        RoundedCheckBox()
        CardCheckBox()
        CheckBoxWithColor()
        MultipleCheckBoxes()
        TriSateCheckBox()
    }
}

@Composable
fun SimpleCheckBox() {
    val isChecked = remember { mutableStateOf(false) }

    Checkbox(checked = isChecked.value, onCheckedChange = {
        isChecked.value = it
    })
}

@Composable
fun CheckBoxWithTitle() {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }

    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox
            ),
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null
        )
        Text(
            text = "Option selection",
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
fun RoundedCheckBox() {
    val isChecked = remember { mutableStateOf(false) }
    val checkedText = remember { mutableStateOf("Unchecked") }
    val circleSize = remember { mutableStateOf(20.dp) }
    val circleThickness = remember { mutableStateOf(2.dp) }
    val color = remember { mutableStateOf(Color.Gray) }

    Row(
        modifier = Modifier.toggleable(value = isChecked.value, role = Role.Checkbox) {
            isChecked.value = it

            if (isChecked.value) {
                checkedText.value = "Checked"
                circleSize.value = 40.dp
                circleThickness.value = 3.dp
                color.value = Color.Black
            } else {
                checkedText.value = "Unchecked"
                circleSize.value = 20.dp
                circleThickness.value = 2.dp
                color.value = Color.Gray
            }
        }
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(circleSize.value)
                .background(color.value)
                .padding(circleThickness.value)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            if (isChecked.value) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "")
            }
        }
        Text(
            text = checkedText.value,
            color = color.value,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
fun CardCheckBox() {
    val isCheck = remember { mutableStateOf(false) }

    Row {
        Card(
            modifier = Modifier.background(Color.White),
            elevation = 0.dp,
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(1.5.dp, Color.Gray)
        ) {
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(if (isCheck.value) Color.Black else Color.White)
                    .clickable {
                        isCheck.value = !isCheck.value
                    },
                contentAlignment = Alignment.Center
            ) {
                if(isCheck.value)
                    Icon(Icons.Default.Check, contentDescription = "", tint = Color.White)
            }
        }
        Text(
            modifier = Modifier
                .align(CenterVertically)
                .padding(start = 10.dp),
            text = "I agree with the terms & condition",
        )
    }
}

@Composable
fun CheckBoxWithColor() {
    var checked by remember { mutableStateOf(false) }

    val contextForToast = LocalContext.current.applicationContext

    Row(verticalAlignment = CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked_ ->
                checked = checked_
                Toast.makeText(contextForToast, "checked_ = $checked_", Toast.LENGTH_SHORT).show()
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green
            )
        )
        Text(
            modifier = Modifier.padding(start = 2.dp),
            text = "Cheese"
        )
    }
}

@Composable
fun MultipleCheckBoxes() {
    val fruitsList: List<String> = listOf("Apple", "Mangoes", "Melons")
    val contextForToast = LocalContext.current.applicationContext

    Column(horizontalAlignment = Alignment.Start) {
        fruitsList.forEach { fruitName ->
            var checked by remember { mutableStateOf(true) }

            Row(verticalAlignment = CenterVertically) {
                Checkbox(
                    checked = checked,
                    onCheckedChange  = { checked_ ->
                        checked = checked_
                        Toast.makeText(contextForToast, "$fruitName $checked_", Toast.LENGTH_SHORT).show()
                    }
                )

                Text(
                    modifier = Modifier.padding(start = 2.dp),
                    text = fruitName
                )
            }
        }
    }
}

@Composable
fun TriSateCheckBox() {
    val (state, onStateChange) = remember {
        mutableStateOf(false)
    }
    val (state2, onStateChange2) = remember {
        mutableStateOf(false)
    }
    val (state3, onStateChange3) = remember {
        mutableStateOf(false)
    }

    val parentState = remember(key1 = state, key2 = state2, key3 = state3) {
        if (state && state2 && state3) androidx.compose.ui.state.ToggleableState.On
        else if (!state && !state2 && !state3) androidx.compose.ui.state.ToggleableState.Off
        else androidx.compose.ui.state.ToggleableState.Indeterminate
    }

    val onParentClick = {
        val s = parentState != androidx.compose.ui.state.ToggleableState.On
        onStateChange(s)
        onStateChange2(s)
        onStateChange3(s)
    }

    TriStateCheckbox(
        state = parentState,
        onClick = onParentClick
    )

    Checkbox(checked = state, onCheckedChange = onStateChange)
    Checkbox(checked = state2, onCheckedChange = onStateChange2)
    Checkbox(checked = state3, onCheckedChange = onStateChange3)
}