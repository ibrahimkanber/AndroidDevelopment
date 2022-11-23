package com.ibrahim.androidwithjetpackcompose.lessons.widgets

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SwitchUsage(){
    val switchState= remember{ mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Switch(
            checked = switchState.value,
            onCheckedChange = {
                switchState.value=it
                Log.e("Switch",switchState.value.toString())
            },
            colors = SwitchDefaults.colors(
                checkedTrackColor = Color.Red,
                checkedThumbColor = Color.Blue,
                uncheckedTrackColor = Color.Green,
                uncheckedThumbColor = Color.Black
            )

        )
    }
}