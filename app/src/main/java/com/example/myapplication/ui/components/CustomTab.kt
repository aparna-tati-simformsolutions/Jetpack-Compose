package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomTab() {
    val selectedIndex = remember { mutableStateOf(0) }
    val list = listOf("Active", "Completed")

    TabRow(
        selectedTabIndex = selectedIndex.value,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clip(RoundedCornerShape(50)),
        indicator = { tabPositions: List<TabPosition> ->  
            Box {}
        }
    ) {
        list.forEachIndexed { index: Int, text: String ->
            val selected = selectedIndex.value == index
            Tab(
                modifier =
                if (selected)
                    Modifier.clip(RoundedCornerShape(50)).background(Color.White)
                else
                    Modifier.clip(RoundedCornerShape(50)).background(Color(0xff1E76DA)),
                selected = selected,
                onClick = { selectedIndex.value = index },
            ) {
                Text(text = text, color = Color(0xff6FAAEE))
            }
        }
    }
}