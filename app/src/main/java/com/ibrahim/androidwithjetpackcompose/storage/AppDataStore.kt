package com.ibrahim.androidwithjetpackcompose.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppDataStore(val context: Context) {
    private val Context.ds: DataStore<Preferences> by preferencesDataStore("info")

    companion object {
        val NAME_KEY = stringPreferencesKey("NAME")
        val AGE_KEY = intPreferencesKey("AGE")
        val IS_SINGLE_KEY = booleanPreferencesKey("IS_SINGLE")
        val FRIENDS_KEY = stringSetPreferencesKey("FRIENDS")
    }

    suspend fun saveName(name: String) {
        context.ds.edit {
            it[NAME_KEY] = name
        }
    }

    suspend fun readName() :String{
        val p=context.ds.data.first()
        return p[NAME_KEY]?:"not found"
    }

    suspend fun deleteName(){
        context.ds.edit {
            it.remove(NAME_KEY)
        }
    }
}