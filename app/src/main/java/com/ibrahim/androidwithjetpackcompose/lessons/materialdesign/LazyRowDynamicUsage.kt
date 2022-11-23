package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun CityItem(name:String,navController: NavController){
    Card(
        modifier = Modifier
            .padding(all = 5.dp)
            .size(200.dp, 100.dp)
    ) {
        Row(
            modifier=Modifier.clickable {
                navController.navigate("detail/$name")
            },
               // .background(Color.Green),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Row(
                modifier = Modifier
                    //.background(Color.Red)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                ,

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,


            ) {
                Text(text = name)
                OutlinedButton(
                    onClick ={}
                ) {
                    Text(text = "Select")
                }
            }
        }
    }
}

@Composable
fun LazyRowDynamicUsage(navController: NavController){
    val cities= remember {
        mutableStateListOf("Weimar","Jena","Bielefeld")
    }
    LazyRow{
       items(
           count=cities.count(),
           itemContent = {
               CityItem(cities[it],navController)
           }
       )
    }
}