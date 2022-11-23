package com.ibrahim.androidwithjetpackcompose.lessons.widgets

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.ibrahim.androidwithjetpackcompose.R

@Composable
fun FloatingActionButtonExample(name: String) {

    Scaffold(
        content = {},
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = Color.Red,
                content = {
                    Icon(
                        painterResource(id =R.drawable.add_new_image ) ,
                        contentDescription ="",
                        tint = Color.White
                    )
                }
            )
        }

    )

}

@Composable
fun FloatingActionButtonExampleExtended(name: String) {

    Scaffold(
        content = {},
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = Color.Red,
                text = { Text(text = "Add") },
                icon = {
                    Icon(
                        painterResource(id = R.drawable.add_new_image) ,
                        contentDescription ="",
                        tint = Color.White
                    )
                },

                )
        }

    )

}