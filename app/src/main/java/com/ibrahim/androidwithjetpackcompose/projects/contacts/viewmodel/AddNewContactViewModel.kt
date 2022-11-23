package com.ibrahim.androidwithjetpackcompose.projects.contacts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.ibrahim.androidwithjetpackcompose.projects.contacts.repo.ContactsDaoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewContactViewModel(application: Application) : AndroidViewModel(application) {
    private val contactRepository=ContactsDaoRepository(application)


    fun addNewContact(personName:String, personTel:String){
        CoroutineScope(Dispatchers.Main).launch {
            contactRepository.add(personName,personTel)
        }
    }
}