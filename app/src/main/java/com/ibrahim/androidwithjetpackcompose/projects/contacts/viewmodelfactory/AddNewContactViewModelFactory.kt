package com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodel.AddNewContactViewModel
import com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodel.HomeScreenViewModel

class AddNewContactViewModelFactory(var application: Application) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddNewContactViewModel(application) as T
    }
}