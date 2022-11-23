package com.ibrahim.androidwithjetpackcompose.lessons.widgets

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import com.ibrahim.androidwithjetpackcompose.R

@Composable
fun ImageExample() {
    Column {
        val activity = (LocalContext.current) as Activity
        Image(painter = painterResource(id = R.drawable.yemekresim), contentDescription = "")
        Image(
            bitmap = ImageBitmap.imageResource(
                id = activity.resources.getIdentifier(
                    "yemekresim",
                    "drawable",
                    activity.packageName
                )
            ),
            contentDescription = ""
        )
        Image(painter = painterResource(id = R.drawable.picture), contentDescription = "")
    }
}