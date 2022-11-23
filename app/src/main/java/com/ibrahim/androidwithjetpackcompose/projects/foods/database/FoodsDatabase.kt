package com.ibrahim.androidwithjetpackcompose.projects.foods.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ibrahim.androidwithjetpackcompose.projects.contacts.database.ContactsDatabase
import com.ibrahim.androidwithjetpackcompose.projects.foods.dao.FoodsDao
import com.ibrahim.androidwithjetpackcompose.projects.foods.entity.Food


@Database(entities = [Food::class], version = 1)
abstract class FoodsDatabase:RoomDatabase() {
    abstract fun foodsDao():FoodsDao
    companion object {
        private var INSTANCE: FoodsDatabase? = null
        fun accessDatabase(context: Context): FoodsDatabase? {
            if (INSTANCE === null) {
                synchronized(FoodsDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FoodsDatabase::class.java,
                        "foods.sqlite"
                    ).createFromAsset("foods.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}