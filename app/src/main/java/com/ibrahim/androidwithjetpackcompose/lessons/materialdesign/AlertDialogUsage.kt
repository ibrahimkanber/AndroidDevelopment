package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun AlertDialogUsage() {

    val isOpen = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (isOpen.value) {
            AlertDialog(
                onDismissRequest = {
                    isOpen.value = false
                },
                title = { Text(text = "Title") },
                text = { Text(text = "Message") },
                confirmButton = {
                    Text(
                        text = "Yes",
                        color = Color.Green,
                        modifier = Modifier.clickable {
                            isOpen.value = false
                        }
                    )
                },
                dismissButton = {
                    Text(
                        text = "No",
                        color = Color.Red,
                        modifier = Modifier.clickable {
                            isOpen.value = false
                        })
                }
            )
        }

    }
}