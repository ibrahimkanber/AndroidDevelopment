package com.ibrahim.androidwithjetpackcompose.projects.contacts.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ibrahim.androidwithjetpackcompose.projects.contacts.database.ContactsDatabase
import com.ibrahim.androidwithjetpackcompose.projects.contacts.entity.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ContactsDaoRepository (private val application: Application){
    private var contactList=MutableLiveData<List<Person>>(mutableListOf<Person>())
    var db:ContactsDatabase = ContactsDatabase.accessDatabase(application)!!



    fun loadAllContacts(){
        val job: Job = CoroutineScope(Dispatchers.Main).launch {
            val contacts = db.personsDao().getAllContacts()
            Log.e("contactslength",contacts.size.toString())
            contactList.value=contacts
        }
    }

    fun getContacts():MutableLiveData<List<Person>>{
        return contactList
    }

    suspend fun search(searchedValue:String){
        contactList.value=db.personsDao().getSearchResult(searchedValue)
    }

    suspend fun add(personName:String, personTel:String){
        val p=Person(0,personName,personTel)
        db.personsDao().addNewContact(p)
    }
    suspend fun update(id:Int,personName:String,personTel:String){
        val p=Person(id,personName,personTel)
        db.personsDao().updateContact(p)
    }

    suspend fun delete(person:Person){
        db.personsDao().deleteContact(person)
        loadAllContacts()
    }
}