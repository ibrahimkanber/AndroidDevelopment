package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation.screens.DetailScreen
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation.screens.HomeScreen

@Composable
fun MaterialStackNavigator(){
    val navController= rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeStackScreen.HOME.route

    ) {
        composable(route = HomeStackScreen.HOME.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = HomeStackScreen.DETAIL.route,
            arguments = listOf(navArgument(HomeStackScreen.DETAIL.params) { type = NavType.StringType })
        ) {
            val countryName = it.arguments?.getString(HomeStackScreen.DETAIL.params)!!
            DetailScreen(navController = navController, countryName)
        }
    }
}