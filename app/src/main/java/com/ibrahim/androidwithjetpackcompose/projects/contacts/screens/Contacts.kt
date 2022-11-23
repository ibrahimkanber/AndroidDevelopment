package com.ibrahim.androidwithjetpackcompose.projects.contacts.screens

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.gson.Gson
import com.ibrahim.androidwithjetpackcompose.R
import com.ibrahim.androidwithjetpackcompose.projects.contacts.entity.Person
import com.ibrahim.androidwithjetpackcompose.projects.contacts.screens.ContactStackScreen
import com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodel.HomeScreenViewModel
import com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodelfactory.HomeScreenViewModelFactory
import com.ibrahim.androidwithjetpackcompose.ui.theme.extendedColors
import kotlinx.coroutines.launch

@Composable
fun ContactsScreen(navHostController: NavHostController) {
    val isSearchActive = remember {
        mutableStateOf(false)
    }

    val searchedValue = remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    val viewModel: HomeScreenViewModel = viewModel(
        factory = HomeScreenViewModelFactory(context.applicationContext as Application)
    )
    val contactList = viewModel.contactList.observeAsState()
    LaunchedEffect(key1 = true) {
        viewModel.loadContact()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (isSearchActive.value) {
                        TextField(
                            value = searchedValue.value,
                            onValueChange = {
                                searchedValue.value = it
                                    viewModel.searchContact(it)
                            },

                            )
                    } else {
                        Text(text = "Contacts")

                    }


                },
                actions = {
                    if (isSearchActive.value) {
                        IconButton(
                            onClick = {
                                isSearchActive.value = false
                                searchedValue.value = ""
                            },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.close),
                                contentDescription = ""
                            )
                        }
                    } else {
                        IconButton(

                            onClick = {
                                isSearchActive.value = true
                            },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = ""
                            )
                        }
                    }

                },
                modifier = Modifier.height(60.dp)

            )

        },
        content = {
            LazyColumn {
                items(
                    itemContent = {
                        val person = contactList.value!![it]
                        Card(
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                        ) {
                            Row(modifier = Modifier.clickable {
                                val personJson = Gson().toJson(person)
                                navHostController.navigate("${ContactStackScreen.DETAIL.mainRoute}/${personJson}")
                            }) {
                                Row(
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .fillMaxWidth(),

                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "${person.person_name} ${person.person_tel}")
                                    IconButton(onClick = {
                                        viewModel.deleteContact(person)
                                    }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.delete),
                                            contentDescription = ""
                                        )
                                    }
                                }
                            }
                        }
                    },
                    count = contactList.value!!.size
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate(ContactStackScreen.SAVE.route)
                },
                backgroundColor = MaterialTheme.extendedColors.primary,
                content = {
                    Icon(painter = painterResource(id = R.drawable.add), contentDescription = "")
                }
            )
        },
    )
}