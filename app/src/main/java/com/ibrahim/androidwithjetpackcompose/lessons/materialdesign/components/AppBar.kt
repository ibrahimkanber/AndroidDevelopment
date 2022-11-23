package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ibrahim.androidwithjetpackcompose.ui.theme.extendedColors
import com.ibrahim.androidwithjetpackcompose.R
@Composable
fun AppBar(
    title:String= stringResource(id = R.string.app_name),
    background: Color = MaterialTheme.extendedColors.primary,
    contentColor: Color = Color.White,
    onNavigationIconClick:()->Unit
){
    TopAppBar(
        title={ Text(text = title) },
        backgroundColor =background,
        contentColor =contentColor,
        navigationIcon = {
            IconButton(onClick =onNavigationIconClick ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Toggle drawer")
            }
        }

        )
}