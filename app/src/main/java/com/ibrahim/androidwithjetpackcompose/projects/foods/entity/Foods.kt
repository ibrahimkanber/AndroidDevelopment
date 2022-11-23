package com.ibrahim.androidwithjetpackcompose.projects.foods.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "foods")
data class Food(
    @ColumnInfo(name="id")  @PrimaryKey  @NotNull val id:Int,
    @ColumnInfo(name="name") @NotNull val name:String,
    @ColumnInfo(name="picture") @NotNull val picture:String,
    @ColumnInfo(name="price") @NotNull val price:Int) {
}
