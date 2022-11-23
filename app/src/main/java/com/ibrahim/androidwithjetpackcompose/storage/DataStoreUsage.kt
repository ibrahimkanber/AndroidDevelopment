package com.ibrahim.androidwithjetpackcompose.storage

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.ibrahim.androidwithjetpackcompose.projects.contacts.database.ContactsDatabase
import com.ibrahim.androidwithjetpackcompose.projects.contacts.entity.Persons
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
fun DataStoreUsage() {
    val context = LocalContext.current
    val db = ContactsDatabase.accessDatabase(context)!!

    val appDataStore = AppDataStore(context)
    /*
    LaunchedEffect(key1 = true ){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            appDataStore.saveName("Ibrahim")

            val savedName=appDataStore.readName()
            Log.e("store", savedName)
        }
    }

     */
    LaunchedEffect(key1 = true) {
        //add(db)
        //update(db)
        //delete(db)
        //getRandom(db)
        //getById(db)
        //checkCountByNme(db)
        //search(db)
        //getAllContacts(db)

    }
}

/*
fun getAllContacts(db: ContactsDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val contactList = db.personsDao().getAllContacts()
        for (p in contactList) {
            Log.e("dbOps", p.person_name)
        }
    }
}

fun add(db: ContactsDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val p1 = Persons(0, "Ali", "33333")
        db.personsDao().addNewContact(p1)

    }
}


fun update(db: ContactsDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val p1 = Persons(4, "Updated Name", "33333")
        db.personsDao().updateContact(p1)

    }
}

fun delete(db: ContactsDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val p1 = Persons(4, "", "")
        db.personsDao().deleteContact(p1)


    }
}


fun getRandom(db: ContactsDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val randomList= db.personsDao().getRandomContact()
        for (p in randomList) {
            Log.e("dbOps", p.person_name)
        }
    }
}


fun search(db: ContactsDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val searchList= db.personsDao().getSearchResult("i")
        for (p in searchList) {
            Log.e("dbOps", p.person_name)
        }
    }
}

fun getById(db: ContactsDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val p= db.personsDao().getContactById(2)
        Log.e("dbOps", p.person_name)
    }
}

fun checkCountByNme(db: ContactsDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val count= db.personsDao().checkContactCountByCondition("Mehmet")
        Log.e("dbOps",count.toString())
    }
}

 */





