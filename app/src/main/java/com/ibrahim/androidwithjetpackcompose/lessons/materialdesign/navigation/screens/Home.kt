package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.LazyColumnDynamicUsage
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.LazyRowDynamicUsage

@Composable
fun HomeScreen(navController: NavController){
    LazyColumnDynamicUsage(navController)
    //LazyRowDynamicUsage(navController = navController)
}