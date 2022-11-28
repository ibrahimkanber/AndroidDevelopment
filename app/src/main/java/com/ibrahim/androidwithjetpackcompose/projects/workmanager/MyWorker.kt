package com.ibrahim.androidwithjetpackcompose.projects.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context, workerParams:WorkerParameters) : Worker(appContext,workerParams){
    override fun doWork(): Result {
        val sum=10+20
        Log.e("result",sum.toString())
        return Result.success()
    }
}