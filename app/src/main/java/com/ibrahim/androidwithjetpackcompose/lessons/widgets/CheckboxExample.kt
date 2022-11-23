package com.ibrahim.androidwithjetpackcompose.lessons.widgets

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CheckboxExample(){
    val checkboxState= remember{ mutableStateOf(false) }
    val text=if (checkboxState.value) "Enabled" else "Disabled"
    //val text=if (checkboxState.value) "Enabled" else (if (false) "at" else "inek")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,

            ) {
            Checkbox(
                checked = checkboxState.value,
                onCheckedChange = {
                    checkboxState.value=it
                    Log.e("Checkbox","value ${checkboxState.value}") },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    checkmarkColor = Color.Black
                ),
            )
            Text(text )
        }

        Button(
            onClick = {
                Log.e("Checkbox","value ${checkboxState.value}")
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color.Magenta
            ),
            shape = RoundedCornerShape(50),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Text(text = "Show")
        }
    }

}