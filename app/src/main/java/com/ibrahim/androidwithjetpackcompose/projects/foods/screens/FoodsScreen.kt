package com.ibrahim.androidwithjetpackcompose.projects.foods.screens

import android.app.Application
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.gson.Gson
import com.ibrahim.androidwithjetpackcompose.projects.foods.components.AppTopAppBar
import com.ibrahim.androidwithjetpackcompose.projects.foods.components.FoodCard
import com.ibrahim.androidwithjetpackcompose.projects.foods.entity.Food
import com.ibrahim.androidwithjetpackcompose.projects.foods.navigation.FoodRoutes
import com.ibrahim.androidwithjetpackcompose.projects.foods.viewmodel.FoodsPageViewModel
import com.ibrahim.androidwithjetpackcompose.projects.foods.viewmodelfactory.FoodsPageViewModelFactoryFactory


@Composable
fun FoodsScreen(navController: NavController) {
    val viewModel: FoodsPageViewModel = viewModel(
        factory = FoodsPageViewModelFactoryFactory(LocalContext.current.applicationContext as Application)
    )
    val foodList = viewModel.foodList.observeAsState()
    /*
    val foodList= remember {
        mutableStateListOf<Food>()
    }

    LaunchedEffect(key1=true ){
        val f1=Food(1,"Baklava","baklava",25)
        val f2=Food(2,"Meatball","meatball",45)
        foodList.add(f1)
        foodList.add(f2)
    }

     */

    Scaffold(
        topBar = {
            AppTopAppBar(title = "Foods")
        }

    ) {
        LazyColumn {
            items(
                count = foodList.value!!.count()

            ) {
                fun navigateToDetail() {
                    val jsonFood = Gson().toJson(foodList.value!![it])
                    navController.navigate("${FoodRoutes.FOOD_DETAIL.route}/$jsonFood")
                }
                FoodCard(foodList.value!![it]) { navigateToDetail() }
            }
        }
    }
}