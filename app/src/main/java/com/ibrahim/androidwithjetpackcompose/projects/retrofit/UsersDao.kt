package com.ibrahim.androidwithjetpackcompose.projects.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface UsersDao {
    @GET("todos/1")
    fun getTodo():Call<Task>
}