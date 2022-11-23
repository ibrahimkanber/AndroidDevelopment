package com.ibrahim.androidwithjetpackcompose.projects.guessnumber.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ibrahim.androidwithjetpackcompose.projects.guessnumber.screens.GuessScreen
import com.ibrahim.androidwithjetpackcompose.projects.guessnumber.screens.Home
import com.ibrahim.androidwithjetpackcompose.projects.guessnumber.screens.ResultScreen

@Composable
fun RootNavigator(){
    val navController= rememberNavController()
    NavHost(
        navController = navController, startDestination = Routes.HOME.route ){
        composable(route=Routes.HOME.route){
            Home(navController)
        }
        composable(route=Routes.GUESS.route){
            GuessScreen(navController)
        }
        composable(
            route="${Routes.RESULT.route}/{result}",
            arguments = listOf(navArgument("result"){type= NavType.BoolType})
        ){
            val res=it.arguments?.getBoolean("result")!!
            Log.e("args","$res")
            ResultScreen(navController,res)
        }
    }
}