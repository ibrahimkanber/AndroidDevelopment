package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun CountyItem(name:String,navController: NavController){
    Card(
        modifier = Modifier
            .padding(all = 5.dp)
            .fillMaxWidth()
    ){
        Row(
            Modifier
                .clickable {
                    navController.navigate("detail/$name")
                }){
           Row(
               verticalAlignment = Alignment.CenterVertically,
               modifier = Modifier.padding(all=10.dp).fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween

           ) {
               Text(text = name)
               OutlinedButton(
                   onClick = {},
                   shape = RoundedCornerShape(8.dp),
                   contentPadding = PaddingValues(0.dp),


               ) {
                   Text("select", fontSize = 12.sp)

               }
           }
        }
    }
}

@Composable
fun LazyColumnDynamicUsage(navController: NavController){
    val countries= remember {
        mutableStateListOf("Turkey","Germany","Japan")
    }

    LazyColumn{
        items(
            count = countries.count(),
            itemContent = {
                CountyItem(countries[it],navController)
            }
        )
    }
}