package com.ibrahim.androidwithjetpackcompose.projects.guessnumber.screens

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ibrahim.androidwithjetpackcompose.projects.guessnumber.navigation.Routes
import com.ibrahim.androidwithjetpackcompose.ui.components.ButtonPrimary
import com.ibrahim.androidwithjetpackcompose.ui.components.ColumnContainer
import com.ibrahim.androidwithjetpackcompose.ui.components.Title
import com.ibrahim.androidwithjetpackcompose.ui.components.TitleVariants
import kotlin.random.Random

@Composable
fun GuessScreen(navController: NavController) {
    val numberState = remember { mutableStateOf("") }
    val randomNumber = remember { mutableStateOf(0) }
    val hint = remember { mutableStateOf("") }
    val credit = remember { mutableStateOf(5) }
    ColumnContainer {
        Title(text = "Credit : ${credit.value}", color = Color.Red)
        Title(text = "Help ${hint.value}", selected = TitleVariants.SMALL, color = Color.Red)
        TextField(
            value = numberState.value,
            onValueChange = { numberState.value = it },
            label = {
                Text(
                    text = "Guess"
                )
            })
        ButtonPrimary(text = "Check") {
            credit.value-=1
            val enteredValue=numberState.value.toInt()
            if(enteredValue==randomNumber.value){
                navController.navigate("${Routes.RESULT.route}/true") {
                    popUpTo(Routes.GUESS.route) { inclusive = true }
                }
                return@ButtonPrimary
            }
            if(enteredValue<randomNumber.value){
                hint.value="Increase"
            }
            if(enteredValue>randomNumber.value){
                hint.value="Decrease"
            }
            if(credit.value==0){
                navController.navigate("${Routes.RESULT.route}/false") {
                    popUpTo(Routes.GUESS.route) { inclusive = true }
                }
            }

            numberState.value=""
        }
        LaunchedEffect(key1 = true  ){
            randomNumber.value= Random.nextInt(101)
            Log.e("random",randomNumber.value.toString())
        }




    }
}