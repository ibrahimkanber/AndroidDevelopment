package com.ibrahim.androidwithjetpackcompose.projects.workmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.ibrahim.androidwithjetpackcompose.R

fun createNotification(context: Context) {
    val builder: NotificationCompat.Builder
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "default"
        val channelName = "Name"
        val channelDesc = "Desc"
        val channelPrioro = NotificationManager.IMPORTANCE_HIGH

        var channel: NotificationChannel? = notificationManager.getNotificationChannel(channelId)
        if (channel == null) {
            channel = NotificationChannel(channelId, channelName, channelPrioro)
            channel.description = channelDesc
            notificationManager.createNotificationChannel(channel)
        }

        builder = NotificationCompat.Builder(context, channelId)
        builder.setContentTitle("Title")
            .setContentText("Content")
            .setSmallIcon(R.drawable.picture)
            .setAutoCancel(true)


    } else {
        builder = NotificationCompat.Builder(context)
        builder.setContentTitle("Title")
            .setContentText("Content")
            .setSmallIcon(R.drawable.picture)
            .setAutoCancel(true)
            .priority = Notification.PRIORITY_HIGH

    }

    notificationManager.notify(1, builder.build())
}

class MyWorkerNotification(appContext: Context, workerParams: WorkerParameters) : Worker(appContext,workerParams){
    override fun doWork(): Result {
        createNotification(applicationContext)
        return Result.success()
    }
}