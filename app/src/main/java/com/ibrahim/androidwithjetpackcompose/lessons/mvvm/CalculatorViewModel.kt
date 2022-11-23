package com.ibrahim.androidwithjetpackcompose.lessons.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel :ViewModel(){
    var result=MutableLiveData<String>("0")
    private val mathRepository=MathRepository()
    init {
        result= mathRepository.getResult()
    }
    fun add(number1:String,number2:String){
        mathRepository.addNumbers(number1,number2)
    }
}