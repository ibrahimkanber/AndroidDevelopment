package com.ibrahim.androidwithjetpackcompose.projects.foods.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibrahim.androidwithjetpackcompose.projects.foods.entity.Food
import com.ibrahim.androidwithjetpackcompose.projects.foods.repo.FoodsDaoRepository

class FoodsPageViewModel(application: Application): AndroidViewModel(application) {
    private val foodsDaoRepository=FoodsDaoRepository(application)
    var foodList= MutableLiveData<List<Food>>()

    init {
        loadFoods()
        foodList=foodsDaoRepository.getAllFoods()
    }
    private fun loadFoods(){
        foodsDaoRepository.loadFoods()
    }
}