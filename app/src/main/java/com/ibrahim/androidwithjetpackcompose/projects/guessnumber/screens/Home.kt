package com.ibrahim.androidwithjetpackcompose.projects.guessnumber.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ibrahim.androidwithjetpackcompose.ui.components.ButtonPrimary
import com.ibrahim.androidwithjetpackcompose.ui.components.ColumnContainer
import com.ibrahim.androidwithjetpackcompose.ui.components.ImageView
import com.ibrahim.androidwithjetpackcompose.ui.components.Title
import com.ibrahim.androidwithjetpackcompose.R
import com.ibrahim.androidwithjetpackcompose.projects.guessnumber.navigation.Routes

@Composable
fun Home(navController: NavController){
    fun start(){ navController.navigate(Routes.GUESS.route) }
    ColumnContainer {
        Title(text = "Number Guess Game")
        ImageView(id =R.drawable.casino )
        ButtonPrimary(text = "Start game") { start() }
        //ButtonPrimary(text = "Start game",{ start() }
    }
}