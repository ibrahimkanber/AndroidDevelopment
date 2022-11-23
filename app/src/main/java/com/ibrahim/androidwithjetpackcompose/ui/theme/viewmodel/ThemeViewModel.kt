package com.ibrahim.androidwithjetpackcompose.ui.theme.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ThemeViewModel:ViewModel() {
    var themeValue=MutableLiveData<Boolean>(false)

    fun update(){
        Log.e("trigger","trigger")
        themeValue.value=!themeValue.value!!
    }

}