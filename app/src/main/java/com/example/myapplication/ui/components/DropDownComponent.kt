package com.example.myapplication.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext

@Composable
fun DropDownComponent() {
    Column {
        SimpleDropDown()
        ReadOnlyExposedDropDown()
        EditableExposedDropDown()
    }
}

@Composable
fun SimpleDropDown() {
    val listItems = arrayOf("Favorites", "Options", "Settings", "Share")
    val disabledItem = 1
    val contextForToast = LocalContext.current.applicationContext
    val expanded = remember {
        mutableStateOf(false)
    }

    Column {
        Text(text = "DropDown Menu")
        Box(
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = {
                expanded.value = true
            }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Open Options"
                )
            }

            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = {
                    expanded.value = false
                }
            ) {
                listItems.forEachIndexed { itemIndex, itemValue ->
                    DropdownMenuItem(
                        onClick = {
                            Toast.makeText(contextForToast, itemValue, Toast.LENGTH_SHORT)
                                .show()
                            expanded.value = false
                        },
                        enabled = (itemIndex != disabledItem)
                    ) {
                        Text(text = itemValue)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ReadOnlyExposedDropDown() {
    val listItems = arrayOf("Favorites", "Options", "Settings", "Share")
    val contextForToast = LocalContext.current.applicationContext
    val expanded = remember { mutableStateOf(false) }
    val selectedItem = remember { mutableStateOf(listItems[0]) }

    Column {
        Text(text = "Read-Only Exposed Dropdown Menu")

        ExposedDropdownMenuBox(expanded = expanded.value, onExpandedChange = {
            expanded.value = !expanded.value
        }) {
            TextField(
                value = selectedItem.value,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Label") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded.value
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
        }

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            listItems.forEach { selectedOption ->
                DropdownMenuItem(onClick = {
                    selectedItem.value = selectedOption
                    Toast.makeText(contextForToast, selectedOption, Toast.LENGTH_SHORT).show()
                    expanded.value = false
                }) {
                    Text(text = selectedOption)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EditableExposedDropDown() {
    val contextForToast = LocalContext.current.applicationContext
    val listItems = arrayOf("Favorites", "Options", "Settings", "Share")
    val expanded = remember { mutableStateOf(false) }
    val selectedItem = remember { mutableStateOf(listItems[0]) }

    Column {
        Text(text = "Editable Exposed Dropdown Menu")
        ExposedDropdownMenuBox(
            expanded = expanded.value,
            onExpandedChange = {
                expanded.value = !expanded.value
            }
        ) {
            TextField(
                value = selectedItem.value,
                onValueChange = { selectedItem.value = it },
                label = { Text(text = "Label") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded.value
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )

            val filteringOptions =
                listItems.filter { it.contains(selectedItem.value, ignoreCase = true) }

            if (filteringOptions.isNotEmpty()) {
                ExposedDropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false }
                ) {
                    filteringOptions.forEach { selectionOption ->
                        DropdownMenuItem(
                            onClick = {
                                selectedItem.value = selectionOption
                                Toast.makeText(contextForToast, selectedItem.value, Toast.LENGTH_SHORT).show()
                                expanded.value = false
                            }
                        ) {
                            Text(text = selectionOption)
                        }
                    }
                }
            }
        }
    }
}