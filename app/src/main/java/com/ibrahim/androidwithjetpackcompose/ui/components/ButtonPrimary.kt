package com.ibrahim.androidwithjetpackcompose.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonPrimary(text:String,onClick: ()->Unit){
    Button(
        onClick,
        modifier = Modifier.size(250.dp,50.dp)
    ) {
        Text(text = text)
    }
}