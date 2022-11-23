package com.ibrahim.androidwithjetpackcompose.projects.foods.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ibrahim.androidwithjetpackcompose.projects.contacts.entity.Person
import com.ibrahim.androidwithjetpackcompose.projects.foods.database.FoodsDatabase
import com.ibrahim.androidwithjetpackcompose.projects.foods.entity.Food
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodsDaoRepository(private val application: Application)
{
    private val foodList=MutableLiveData<List<Food>>(mutableListOf<Food>())
    val db:FoodsDatabase=FoodsDatabase.accessDatabase(application)!!
    fun loadFoods(){
        /*
        val foods= mutableListOf<Food>()
        val f1=Food(1,"Baklava","baklava",25)
        val f2=Food(2,"Meatball","meatball",45)
        foods.add(f1)
        foods.add(f2)
        foodList.value=foods

         */

        CoroutineScope(Dispatchers.Main).launch {
            val foods=db.foodsDao().getAllFoods()
            foodList.value=foods
        }
    }

    fun getAllFoods():MutableLiveData<List<Food>>{
        return foodList
    }
}