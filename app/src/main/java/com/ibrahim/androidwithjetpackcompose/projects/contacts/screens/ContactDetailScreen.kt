package com.ibrahim.androidwithjetpackcompose.projects.contacts.screens

import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ibrahim.androidwithjetpackcompose.projects.contacts.entity.Person
import com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodel.ContactDetailViewModel
import com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodelfactory.ContactDetailViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun ContactsDetailScreen(person:Person){
    val tfPersonName= remember {
        mutableStateOf("")
    }
    val tfPersonTelNumber= remember {
        mutableStateOf("")
    }
    val context= LocalContext.current
    val localFocusManager= LocalFocusManager.current
    val viewModel:ContactDetailViewModel= viewModel(
        factory = ContactDetailViewModelFactory(context.applicationContext as Application)
    )

    LaunchedEffect(key1 = true){
        tfPersonName.value=person.person_name
        tfPersonTelNumber.value=person.person_tel
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Person Info") })
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = tfPersonName.value,
                    onValueChange = {tfPersonName.value=it},
                    label = { Text(text = "Person name") }
                )
                TextField(
                    value = tfPersonTelNumber.value,
                    onValueChange = {tfPersonTelNumber.value=it},
                    label = { Text(text = "Person name") }
                )
                Button(
                    onClick = {
                        viewModel.updateContact(person.person_id,tfPersonName.value,tfPersonTelNumber.value)
                        localFocusManager.clearFocus()
                    },
                    modifier = Modifier.size(250.dp,50.dp)
                ) {
                    Text(text = "Update")
                }
            }
        },
    )
}