package com.ibrahim.androidwithjetpackcompose.projects.contacts.dao

import androidx.room.*
import com.ibrahim.androidwithjetpackcompose.projects.contacts.entity.Person

@Dao
interface PersonsDao{
    @Query("SELECT * from persons")
    suspend fun getAllContacts():List<Person>

    @Insert
    suspend fun addNewContact(person:Person)

    @Update
    suspend fun updateContact(person:Person)

    @Delete
    suspend fun deleteContact(person:Person)

    @Query("SELECT * from persons ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomContact():List<Person>

    @Query("SELECT * from persons WHERE person_name like '%' || :searchKey || '%'  ")
    suspend fun getSearchResult(searchKey:String):List<Person>

    @Query("SELECT * from persons WHERE person_id=:personId ")
    suspend fun getContactById(personId:Int):Person

    @Query("SELECT count(*) from persons WHERE person_name=:personName ")
    suspend fun checkContactCountByCondition(personName:String):Int

}