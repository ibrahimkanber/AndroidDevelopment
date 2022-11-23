package com.ibrahim.androidwithjetpackcompose.projects.retrofit

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun FetchData(){
    LaunchedEffect(key1 =true ){
        todo()
    }
}

fun todo(){
    val todo=ApiUtils.getUsersDao()

    todo.getTodo().enqueue(object:Callback<Task>{
        override fun onResponse(call: Call<Task>?, response: Response<Task>?) {
            val res=response?.body()
            if (res != null) {
                Log.d("res",res.title)
            }
        }

        override fun onFailure(call: Call<Task>?, t: Throwable?) {
            TODO("Not yet implemented")
        }

    })
}