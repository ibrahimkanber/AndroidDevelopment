package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrahim.androidwithjetpackcompose.R

@Composable
fun CardUsage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth()
            ,

            backgroundColor = Color.Blue,
            shape = RoundedCornerShape(corner= CornerSize(16.dp)),
            border= BorderStroke(2.dp, Color.Magenta),
            elevation = 10.dp
        ) {
            Row(
                modifier = Modifier.clickable { Log.e("Card","Clicked") },
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(all = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(id = R.drawable.sun), contentDescription ="" )
                    Text(text = "Sun",color= Color.White, fontSize = 36.sp)
                }
            }
        }
    }
}