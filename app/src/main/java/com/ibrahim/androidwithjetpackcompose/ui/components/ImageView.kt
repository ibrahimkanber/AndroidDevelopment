package com.ibrahim.androidwithjetpackcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageView(id:Int){
    Image(
        painter = painterResource(id = id),
        contentDescription = "",
        Modifier.size(100.dp),

        )
}