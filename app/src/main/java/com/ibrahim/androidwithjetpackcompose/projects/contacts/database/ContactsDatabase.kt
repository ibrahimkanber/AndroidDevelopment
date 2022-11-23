package com.ibrahim.androidwithjetpackcompose.projects.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ibrahim.androidwithjetpackcompose.projects.contacts.dao.PersonsDao
import com.ibrahim.androidwithjetpackcompose.projects.contacts.entity.Person
import com.ibrahim.androidwithjetpackcompose.projects.contacts.entity.Persons

@Database(entities = [Person::class], version = 1)
abstract class ContactsDatabase : RoomDatabase() {
    abstract fun personsDao(): PersonsDao
    companion object {
        private var INSTANCE: ContactsDatabase? = null
        fun accessDatabase(context: Context): ContactsDatabase? {
            if (INSTANCE === null) {
                synchronized(ContactsDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactsDatabase::class.java,
                        "userContacts"
                    ).createFromAsset("userContacts.db").build()
                }
            }
            return INSTANCE
        }
    }
}