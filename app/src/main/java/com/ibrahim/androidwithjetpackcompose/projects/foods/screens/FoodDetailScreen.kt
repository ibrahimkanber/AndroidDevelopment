package com.ibrahim.androidwithjetpackcompose.projects.foods.screens

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ibrahim.androidwithjetpackcompose.lessons.mvvm.CalculatorViewModel
import com.ibrahim.androidwithjetpackcompose.projects.foods.components.AppTopAppBar
import com.ibrahim.androidwithjetpackcompose.projects.foods.entity.Food
import com.ibrahim.androidwithjetpackcompose.ui.theme.viewmodel.ThemeViewModel

@Composable
fun FoodDetailScreen(food: Food){
    val viewModel:ThemeViewModel= viewModel()
    val res=viewModel.themeValue.observeAsState(false)
    Log.e("theme foods","hello")

    Scaffold(
        topBar = {
            AppTopAppBar(title = food.name)
        },
        content = {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ){

                val activity = LocalContext.current as Activity
                Image(
                    bitmap = ImageBitmap.imageResource(
                        id = activity.resources.getIdentifier(
                            food.picture,
                            "drawable",
                            activity.packageName
                        )
                    ),
                    contentDescription = "",
                    modifier = Modifier.size(200.dp)
                )
                Text(text = "${res.value}")
                Button(onClick = {}) {
                    Text(text = "Order")
                }
                Button(onClick = {
                    viewModel.update()
                }) {
                    Text(text = "Change")
                }


            }
        }

    )
}