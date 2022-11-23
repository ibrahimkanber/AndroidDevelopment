package com.ibrahim.androidwithjetpackcompose.lessons.widgets

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp


@Composable
fun ClickableExample2(){
    StandardColumn (
        children = {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
                    .clickable {
                        Log.e("Box","Box clicked")
                    }
            )
        },
        "Clickable example"
    )
}

@Composable
fun ClickableExample(){
    StandardColumn (
        children = {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Red)
                    .pointerInput(Unit){
                        detectTapGestures(
                            onTap = {
                                Log.e("Box","Box2 tap")
                            },
                            onDoubleTap = {
                                Log.e("Box","Box2 double tap")
                            },
                            onLongPress = {
                                Log.e("Box","Box2 long press")
                            }

                        )
                    }
            )
        },
        "Clickable example 2"
    )
}