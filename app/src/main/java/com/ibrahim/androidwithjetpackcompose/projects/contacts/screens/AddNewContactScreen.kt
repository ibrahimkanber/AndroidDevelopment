package com.ibrahim.androidwithjetpackcompose.projects.contacts.screens

import android.app.Application
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ibrahim.androidwithjetpackcompose.R
import com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodel.AddNewContactViewModel
import com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodelfactory.AddNewContactViewModelFactory
import com.ibrahim.androidwithjetpackcompose.ui.theme.extendedColors
import kotlinx.coroutines.launch

@Composable
fun AddNewContactScreen() {
    val tfPersonName = remember {
        mutableStateOf("")
    }
    val tfPersonTelNumber = remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current
    val context= LocalContext.current
    val viewModel: AddNewContactViewModel = viewModel(
        factory = AddNewContactViewModelFactory(context.applicationContext as Application)
    )
    val addNewContact: () -> Unit = {
        viewModel.addNewContact(tfPersonName.value, tfPersonTelNumber.value)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Add New Contact") })
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = tfPersonName.value,
                    onValueChange = { tfPersonName.value = it },
                    label = { Text(text = "Person name") }
                )
                TextField(
                    value = tfPersonTelNumber.value,
                    onValueChange = { tfPersonTelNumber.value = it },
                    label = { Text(text = "Person tel") }
                )
                Button(
                    onClick = addNewContact,
                    modifier = Modifier.size(250.dp, 50.dp)
                ) {
                    Text(text = "Save")
                }
            }
        },
    )
}