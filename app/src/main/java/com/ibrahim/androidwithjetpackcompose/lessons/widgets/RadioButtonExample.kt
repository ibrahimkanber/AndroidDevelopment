package com.ibrahim.androidwithjetpackcompose.lessons.widgets

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonExample() {
    val selectedIndex = remember { mutableStateOf(0) }
    val clubList = listOf("Barcelona", "Real Madrid")
    StandardColumn(
        children = {
            Column {
                clubList.forEachIndexed { index, item ->
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                            selectedIndex.value = index
                            Log.e("Radio","Row clicked")
                        }
                    ){
                        RadioButton(
                            selected = index == selectedIndex.value,
                            onClick = {
                                selectedIndex.value = index
                                Log.e("Radio","Button clicked")
                            }
                        )
                        Text(
                            text = item, modifier = Modifier
                                .padding(5.dp)
                                .background(
                                    if (selectedIndex.value == index) Color.Cyan
                                    else Color.White)
                        )
                    }
                }
            }
            Button(
                onClick = {
                    Log.e("RadioButtonExample", clubList[selectedIndex.value])
                }) {
                Text(text = "Show")
            }
        },
        text = "Radio Button Usage"
    )
}