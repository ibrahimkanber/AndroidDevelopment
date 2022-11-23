package com.ibrahim.androidwithjetpackcompose.lessons.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProgressIndicatorExample() {
    val progressState = remember {
        mutableStateOf(false)
    }
    val sliderValue = remember {
        mutableStateOf(0f)
    }
    StandardColumn(
        children = {
            if (progressState.value) {
                CircularProgressIndicator(color = Color.Red, modifier = Modifier.size(40.dp))
            }

            StandardRow(
                children = {
                    Button(
                        onClick = {
                            progressState.value = true
                        }
                    ) {
                        Text(text = "Start")
                    }
                    Button(
                        onClick = {
                            progressState.value = false
                        }
                    ) {
                        Text(text = "Stop")
                    }
                })

            Text("Result  ${sliderValue.value.toInt()}")

            Slider(
                value = sliderValue.value,
                onValueChange = {
                    sliderValue.value = it
                },
                valueRange = 0f..100f,

                colors = SliderDefaults.colors(
                    thumbColor = Color.Green,
                    activeTrackColor = Color.Black,
                    inactiveTickColor = Color.Yellow,
                    inactiveTrackColor = Color.Magenta,

                    ),

                modifier = Modifier.padding(10.dp)





            )


        },
        text = "ProgressIndicatorExample"
    )
}