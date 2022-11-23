package com.ibrahim.androidwithjetpackcompose.projects.foods.components

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.ibrahim.androidwithjetpackcompose.ui.theme.extendedColors

@Composable
fun AppTopAppBar(
    title:String,
    background:Color=MaterialTheme.extendedColors.primary,
    contentColor: Color= Color.White
){
    TopAppBar(
        title={ Text(text = title) },
        backgroundColor =background,
        contentColor =contentColor,

    )
}