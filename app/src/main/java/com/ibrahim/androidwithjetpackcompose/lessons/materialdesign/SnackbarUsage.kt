package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SnackBarUsage() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHost(hostState = it) { data ->
                Snackbar(
                    backgroundColor = Color.White,
                    contentColor = Color.Blue,
                    actionColor = Color.Red,
                    snackbarData = data
                )
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Hello")
                    }
                }) {
                    Text("Default")
                }

                Button(onClick = {
                    val job=scope.launch {
                        val sb = scaffoldState.snackbarHostState
                            .showSnackbar("Are you sure", "Ja")
                        if (sb == SnackbarResult.ActionPerformed) {
                            scaffoldState.snackbarHostState.showSnackbar(
                                "Action completed",
                                duration = SnackbarDuration.Short
                            )


                        }

                    }


                }) {
                    Text("SnackBarAction")
                }
            }
        }
    )
}
