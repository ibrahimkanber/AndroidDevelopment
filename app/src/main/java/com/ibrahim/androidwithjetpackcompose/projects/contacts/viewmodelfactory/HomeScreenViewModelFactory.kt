package com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodel.HomeScreenViewModel

class HomeScreenViewModelFactory(var application: Application) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeScreenViewModel(application) as T
    }
}