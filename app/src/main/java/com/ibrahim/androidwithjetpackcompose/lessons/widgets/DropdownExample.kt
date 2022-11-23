package com.ibrahim.androidwithjetpackcompose.lessons.widgets

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun DropdownExample() {
    val countryList= listOf<String>("Turkey","Germany","Belgium")
    val isVisible= remember{ mutableStateOf(false) }
    StandardColumn(
        children = {
            Box{
                Button(
                    onClick = { isVisible.value=true}) {
                    Text(text = "Show")

                }
                DropdownMenu(
                    expanded =isVisible.value ,
                    onDismissRequest = {isVisible.value=false},

                    ) {
                    DropdownMenuItem(
                        onClick = {
                            Log.e("DropdownItem","Delete")
                            isVisible.value=false

                        }) {
                        Text(text = "Delete")
                    }
                    DropdownMenuItem(
                        onClick = {
                            Log.e("DropdownItem","Add")
                            isVisible.value=false
                        }) {
                        Text(text = "Add")
                    }

                    countryList.forEach{
                        DropdownMenuItem(
                            onClick = {
                                Log.e("DropdownItem",it)
                                isVisible.value=false
                            }) {
                            Text(text = it.uppercase())
                        }
                    }
                }
            }
        },
        text = "fun DropdownUsage(){\n"
    )
}