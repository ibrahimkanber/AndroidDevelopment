package com.ibrahim.androidwithjetpackcompose.projects.foods.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.ibrahim.androidwithjetpackcompose.projects.foods.entity.Food
import com.ibrahim.androidwithjetpackcompose.projects.foods.screens.FoodDetailScreen
import com.ibrahim.androidwithjetpackcompose.projects.foods.screens.FoodsScreen

@Composable
fun FoodNavigator(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination =FoodRoutes.FOODS.route ){
       composable(
           route = FoodRoutes.FOODS.route
       ) {
           FoodsScreen(navController = navController)
       }
        composable(
            route ="${FoodRoutes.FOOD_DETAIL.route}/{food}",
            arguments = listOf(
                navArgument("food"){ type= NavType.StringType }
            )
        ) {
            val json=it.arguments?.getString("food")
            val food=Gson().fromJson(json, Food::class.java)
            FoodDetailScreen(food = food)
        }
    }

}