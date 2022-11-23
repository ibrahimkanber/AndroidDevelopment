package com.ibrahim.androidwithjetpackcompose.lessons.mvvm

import androidx.lifecycle.MutableLiveData

class MathRepository {
    var resultValue= MutableLiveData<String>("0")
    fun addNumbers(number1:String,number2:String){
        val enteredNumber1=number1.toInt()
        val enteredNumber2=number2.toInt()
        resultValue.value=(enteredNumber1+enteredNumber2).toString()
    }
    fun getResult():MutableLiveData<String>{
        return resultValue
    }
}