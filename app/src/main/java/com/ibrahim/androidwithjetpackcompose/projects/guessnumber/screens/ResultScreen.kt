package com.ibrahim.androidwithjetpackcompose.projects.guessnumber.screens

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ibrahim.androidwithjetpackcompose.R
import com.ibrahim.androidwithjetpackcompose.ui.components.ColumnContainer
import com.ibrahim.androidwithjetpackcompose.ui.components.ImageView

@Composable
fun ResultScreen(navController: NavController, result:Boolean,){
    Log.e("result","$result")
    val message= if (result) "Congrats" else "Sorry"
    val imageId=if (result) R.drawable.mood_good else R.drawable.mood_bad
    ColumnContainer {
        Text(text = message, fontSize = 36.sp)
        ImageView(id =imageId)
    }
}