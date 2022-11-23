package com.ibrahim.androidwithjetpackcompose.projects.foods.dao

import androidx.room.Dao
import androidx.room.Query
import com.ibrahim.androidwithjetpackcompose.projects.foods.entity.Food

@Dao
interface FoodsDao {
    @Query("SELECT * from foods")
    suspend fun getAllFoods():List<Food>
}