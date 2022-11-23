package com.ibrahim.androidwithjetpackcompose.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class TitleVariants(val selected:String) {
    SMALL("s"),
    MEDIUM("m")
}



@Composable
fun Title(text:String,selected:TitleVariants=TitleVariants.MEDIUM,color: Color = Color.Black){
    val style= if(selected==TitleVariants.MEDIUM) MaterialTheme.typography.h1 else MaterialTheme.typography.subtitle1
    Text(text, style =style, color=color)
}
