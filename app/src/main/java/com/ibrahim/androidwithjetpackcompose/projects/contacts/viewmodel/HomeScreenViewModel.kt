package com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibrahim.androidwithjetpackcompose.projects.contacts.entity.Person
import com.ibrahim.androidwithjetpackcompose.projects.contacts.repo.ContactsDaoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeScreenViewModel(application:Application) :AndroidViewModel(application){
    private val contactRepository= ContactsDaoRepository(application)
    var contactList=MutableLiveData<List<Person>>()

    init{
        loadContact()
        contactList=contactRepository.getContacts()

    }

    fun loadContact(){
        Log.e("helloooooo","hiiii")
        contactRepository.loadAllContacts()
    }

   fun searchContact(searchedValue:String){
       CoroutineScope(Dispatchers.Main).launch {
        contactRepository.search(searchedValue)
       }
    }
    fun deleteContact(person:Person){
        CoroutineScope(Dispatchers.Main).launch {
            contactRepository.delete(person)
        }

    }
}