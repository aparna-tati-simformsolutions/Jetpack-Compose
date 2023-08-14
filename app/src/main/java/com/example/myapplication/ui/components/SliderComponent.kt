package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Composable
fun SliderComponent() {
    Column {
        SimpleSlider()
        SliderWithColors()
        DiscreteSlider()
        RangeSliderComponent()
        DiscreteRangeSlider()
    }
}

@Composable
fun SimpleSlider() {
    val sliderValue = remember { mutableStateOf(0f) }
    Column {
        Slider(value = sliderValue.value, onValueChange = { sliderValue_ ->
            sliderValue.value = sliderValue_
        }, valueRange = 0f..10f)
        Text(text = sliderValue.value.toString())
    }
}

@Composable
fun SliderWithColors() {
    val sliderValue = remember { mutableStateOf(0f) }

    Slider(
        value = sliderValue.value,
        onValueChange = { sliderValue_ ->
            sliderValue.value = sliderValue_
        },
        valueRange = 0f..10f,
        colors = SliderDefaults.colors(
            thumbColor = Color.Blue,
            activeTrackColor = Color.Green,
            inactiveTrackColor = Color.Red
        )
    )

    Text(text = sliderValue.value.toString())
}

@Composable
fun DiscreteSlider() {
    val sliderValue = remember { mutableStateOf(0f) }
    Slider(
        value = sliderValue.value,
        onValueChange = { sliderValue_ ->
            sliderValue.value = sliderValue_
        },
        valueRange = 0f..10f,
        steps = 4
    )

    Text(text = sliderValue.value.toString())
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RangeSliderComponent() {
    val sliderValue = remember { mutableStateOf(1f..20f) }
    RangeSlider(
        values = sliderValue.value,
        onValueChange = { sliderValue_ ->
            sliderValue.value = sliderValue_
        },
        valueRange = 1f..20f
    )
    Text(text = "Start: ${sliderValue.value.start}, End: ${sliderValue.value.endInclusive}")
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DiscreteRangeSlider() {
    val sliderValue = remember { mutableStateOf(1f..20f) }
    RangeSlider(
        values = sliderValue.value,
        onValueChange = { sliderValue_ ->
            sliderValue.value = sliderValue_
        },
        valueRange = 1f..20f,
        steps = 4
    )
    Text(text = "Start: ${sliderValue.value.start}, End: ${sliderValue.value.endInclusive}")
}