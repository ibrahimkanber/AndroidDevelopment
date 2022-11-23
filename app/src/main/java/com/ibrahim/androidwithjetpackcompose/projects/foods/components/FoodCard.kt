package com.ibrahim.androidwithjetpackcompose.projects.foods.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ibrahim.androidwithjetpackcompose.R
import com.ibrahim.androidwithjetpackcompose.projects.foods.entity.Food

@Composable
fun FoodCard(food: Food, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(all = 5.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth()

            ) {
                val activity = LocalContext.current as Activity
                Image(
                    bitmap = ImageBitmap.imageResource(
                        id = activity.resources.getIdentifier(
                            food.picture,
                            "drawable",
                            activity.packageName
                        )
                    ),
                    contentDescription = "",
                    modifier = Modifier.size(100.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()


                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxHeight()

                    ) {
                        Text(food.name)
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(text = "${food.price}$",color= Color.Blue)

                    }
                    Icon(painter = painterResource(id = R.drawable.arrow), contentDescription ="" )
                }
            }
        }
    }
}