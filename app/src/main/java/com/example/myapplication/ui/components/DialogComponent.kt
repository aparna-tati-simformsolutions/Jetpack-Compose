package com.example.myapplication.ui.components

import android.graphics.fonts.FontFamily
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.myapplication.R

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AlertDialogComponent() {
    Column {
        SimpleAlertDialog()
        CustomAlertDialog()
    }
}

@Composable
fun SimpleAlertDialog() {
    val isDialogOpen = remember { mutableStateOf(false) }
    
    Button(onClick = {
        isDialogOpen.value = true
    }) {
        Text(text = "Simple Dialog")
    }

    if (isDialogOpen.value) {
        AlertDialog(
            onDismissRequest = { isDialogOpen.value = false },
            title = { Text(text = "Alert Title") },
            text = { Text(text = "Alert Text") },
            confirmButton = {
                Button(onClick = {
                    isDialogOpen.value = false
                }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                Button(onClick = {
                    isDialogOpen.value = false
                }) {
                    Text(text = "Dismiss")
                }
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun CustomAlertDialog() {
    val isDialogOpen = remember { mutableStateOf(false) }

    Button(onClick = {
        isDialogOpen.value = true
    }) {
        Text(text = "Custom Dialog")
    }

    if (isDialogOpen.value) {
        DialogBoxDeleteItem {
            isDialogOpen.value = false
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun DialogBoxDeleteItem(
    cornerRadius: Dp = 12.dp,
    deleteButtonColor: Color = Color(0xFFFF0000),
    cancelButtonColor: Color = Color(0xFF35898F),
    titleTextStyle: TextStyle = TextStyle(
        color = Color.Black.copy(alpha = 0.87f),
        fontSize = 20.sp
    ),
    messageTextStyle: TextStyle = TextStyle(
        color = Color.Black.copy(alpha = 0.95f),
        fontSize = 16.sp,
        lineHeight = 22.sp
    ),
    buttonTextStyle: TextStyle = TextStyle(
        fontSize = 16.sp
    ),
    onDismiss: () -> Unit
) {

    val context = LocalContext.current.applicationContext
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val buttonCorner = 6.dp

    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(size = cornerRadius)
        ) {
            Column(modifier = Modifier.padding(all = 16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 6.dp,
                        alignment = Alignment.Start
                    )
                ) {
                    Icon(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.baseline_delete_24),
                        contentDescription = "Delete Icon",
                        tint = deleteButtonColor
                    )
                    Text(
                        text = "Delete Item?",
                        style = titleTextStyle
                    )
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 20.dp),
                    text = "Are you sure you want to delete this item from the list?",
                    style = messageTextStyle
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 10.dp,
                        alignment = Alignment.End
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = interactionSource
                            ) {
                                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show()
                                onDismiss()
                            }
                            .border(
                                width = 1.dp,
                                color = cancelButtonColor,
                                shape = RoundedCornerShape(buttonCorner)
                            )
                            .padding(top = 6.dp, bottom = 8.dp, start = 24.dp, end = 24.dp),
                    ) {
                        Text(
                            text = "Cancel",
                            style = buttonTextStyle,
                            color = cancelButtonColor
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = interactionSource
                            ) {
                                Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show()
                                onDismiss()
                            }
                            .background(
                                color = deleteButtonColor,
                                shape = RoundedCornerShape(buttonCorner)
                            )
                            .padding(top = 6.dp, bottom = 8.dp, start = 24.dp, end = 24.dp),
                    ) {
                        Text(
                            text = "Delete",
                            style = buttonTextStyle,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}