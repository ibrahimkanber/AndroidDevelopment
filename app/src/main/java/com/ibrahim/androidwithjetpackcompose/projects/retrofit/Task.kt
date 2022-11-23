package com.ibrahim.androidwithjetpackcompose.projects.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
/*
"userId": 1,
"id": 1,
"title": "delectus aut autem",
"completed": false

 */

data class Task(
    @SerializedName("userId") @Expose var userId:Int,
    @SerializedName("id") @Expose var id:Int,
    @SerializedName("title") @Expose var title:String,
    @SerializedName("completed") @Expose var completed:Boolean,
){

}
