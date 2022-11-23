package com.ibrahim.androidwithjetpackcompose.projects.retrofit

import retrofit2.Retrofit

class ApiUtils {
    companion object{
        private const val BASE_URL="https://jsonplaceholder.typicode.com/"

        fun getUsersDao():UsersDao{
            return RetrofitClient.getClient(BASE_URL).create(UsersDao::class.java)
        }
    }
}