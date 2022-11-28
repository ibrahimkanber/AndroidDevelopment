package com.ibrahim.androidwithjetpackcompose.projects.glide

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GlideUsage() {
    GlideImage(
        imageModel = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT33Pq5EGy0dvNmqaYBZ6zk7Zn2YAQDuyhv3Q&usqp=CAU",
        modifier = Modifier.size(100.dp,150.dp)
    )
}