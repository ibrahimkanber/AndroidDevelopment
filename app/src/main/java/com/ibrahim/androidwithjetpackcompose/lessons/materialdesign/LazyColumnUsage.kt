package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ibrahim.androidwithjetpackcompose.R

@Composable
fun LazyColumnUsage(){
    LazyColumn{
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier.clickable { Log.e("LazyColumn","click") }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all=5.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.sun), contentDescription = "")
                        Text("Sun")
                    }
                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier.clickable { Log.e("LazyColumn","click") }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all=5.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.sun), contentDescription = "")
                        Text("Sun")
                    }
                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier.clickable { Log.e("LazyColumn","click") }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all=5.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.sun), contentDescription = "")
                        Text("Sun")
                    }
                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier.clickable { Log.e("LazyColumn","click") }
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all=5.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.sun), contentDescription = "")
                        Text("Sun")
                    }
                }
            }
        }
    }
}