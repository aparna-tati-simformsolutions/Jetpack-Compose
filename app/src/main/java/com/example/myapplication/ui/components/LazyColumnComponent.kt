package com.example.myapplication.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun LazyColumnComponent() {
    ColumnRecyclerView()
}

@Composable
fun ListItem(name: String) {
    val expanded = remember {
        mutableStateOf(false)
    }

    val extraPadding = animateDpAsState(
        if (expanded.value) 24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(.1f)) {
                    Text(text = "Course")
                    Text(
                        text = name,
                        style = MaterialTheme.typography.h4.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                }
                OutlinedButton(onClick = {
                    expanded.value = !expanded.value
                }) {
                    Text(text = if (expanded.value) "Show less" else "Show More")
                }
            }

            if (expanded.value) {
                Column(modifier = Modifier.padding(
                    bottom = extraPadding.value.coerceAtLeast(0.dp)
                )) {
                    Text(text = "Some content in this message has been blocked because the sender isn't in your Safe senders list.")
                }
            }
        }
    }
}

@Composable
fun ColumnRecyclerView(names: List<String> = List(1000) { "$it" }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(names) { name ->
            ListItem(name = name)
        }
    }
}