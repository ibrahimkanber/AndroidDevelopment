package com.ibrahim.androidwithjetpackcompose.projects.foods.viewmodelfactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodel.ContactDetailViewModel
import com.ibrahim.androidwithjetpackcompose.projects.foods.viewmodel.FoodsPageViewModel

class FoodsPageViewModelFactoryFactory(val application:Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodsPageViewModel::class.java)) {
            return FoodsPageViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}