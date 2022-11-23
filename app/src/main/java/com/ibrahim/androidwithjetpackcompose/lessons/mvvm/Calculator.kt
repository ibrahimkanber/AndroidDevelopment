package com.ibrahim.androidwithjetpackcompose.lessons.mvvm
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Calculator(){
    val tf1= remember {
        mutableStateOf("")
    }
    val tf2= remember {
        mutableStateOf("")
    }
    val viewModel:CalculatorViewModel= viewModel()
    val result=viewModel.result.observeAsState("153")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = result.value)
        TextField(
            value =tf1.value ,
            onValueChange = { tf1.value = it },
            label={ Text(text = "Number1") }

        )
        TextField(
            value =tf2.value ,
            onValueChange = { tf2.value = it },
            label={ Text(text = "Number2") }

        )
        Button(onClick = {
            viewModel.add(tf1.value,tf2.value)
        }) {
            Text(text = "Add")
        }
    }

}
