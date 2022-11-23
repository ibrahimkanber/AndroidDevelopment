package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrahim.androidwithjetpackcompose.R
@Composable
fun TopAppBarUsage() {
    val isOpen = remember { mutableStateOf(false) }
    val isSearchActive = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Title")
                        Text("Title", fontSize = 12.sp)

                    }

                },
                backgroundColor = colorResource(id = R.color.main),
                contentColor = colorResource(id = R.color.white),
                actions = {
                    Text(
                        text = "Exit",
                        modifier = Modifier.clickable { Log.e("TopBar", "Exit selected") })
                    IconButton(
                        onClick = { Log.e("TopBar", "Info selected") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.info),
                            contentDescription = ""
                        )
                    }
                    IconButton(
                        onClick = {
                            Log.e("TopBar", "More selected")

                            isOpen.value = !isOpen.value;
                        }

                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.more),
                            contentDescription = ""
                        )
                    }

                    DropdownMenu(
                        expanded = isOpen.value,
                        onDismissRequest = { isOpen.value = false }) {
                        DropdownMenuItem(onClick = { isOpen.value = false }) {
                            Text(text = "Option 1")
                        }
                        DropdownMenuItem(onClick = { isOpen.value = false }) {
                            Text(text = "Option 2")
                        }
                    }
                }
            )
        },
        content = {}
    )
}

@Composable
fun TopAppBarSearchUsage() {
    val isSearchActive = remember { mutableStateOf(false) }
    val search = remember {
        mutableStateOf("")
    }
    Scaffold(

        topBar = {
            TopAppBar(
                modifier= Modifier.height(65.dp),
                title = {

                    if (isSearchActive.value) {
                        TextField(
                            modifier= Modifier.height(100.dp),
                            value = search.value,
                            onValueChange = { search.value = it },
                            label = { Text(text = "Search") },

                            textStyle = TextStyle(
                                textAlign = TextAlign.Left,
                                fontSize = 20.sp

                            )



                        )
                    }
                    if (!isSearchActive.value) {
                        Text(text = "Title")
                    }


                },
                backgroundColor = colorResource(id = R.color.main),
                contentColor = colorResource(id = R.color.white),
                actions = {
                    val id=if(isSearchActive.value) R.drawable.close else R.drawable.search
                    IconButton(
                        onClick = { isSearchActive.value = !isSearchActive.value }) {
                        Icon(
                            painter = painterResource(id = id),
                            contentDescription = ""
                        )
                    }

                }
            )
        },
        content = {}
    )
}