package com.ibrahim.androidwithjetpackcompose.projects.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.TimeUtils
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.NotificationCompat
import androidx.work.*
import com.ibrahim.androidwithjetpackcompose.R
import com.ibrahim.androidwithjetpackcompose.projects.workmanager.MyWorker
import com.ibrahim.androidwithjetpackcompose.projects.workmanager.MyWorkerNotification
import java.util.concurrent.TimeUnit

@Composable
fun NotificationPage() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { createNotification(context) }) {
            Text(text = "Create")
        }
        Button(onClick = {
            val workRequirement =
                Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            val request = OneTimeWorkRequestBuilder<MyWorker>()
                .setInitialDelay(10, TimeUnit.SECONDS)
                .setConstraints(workRequirement)
                .build()

            WorkManager.getInstance(context).enqueue(request)
        }) {
            Text(text = "Execute")
        }
        Button(onClick = {

            val request = PeriodicWorkRequestBuilder<MyWorkerNotification>(15,TimeUnit.MINUTES)
                .setInitialDelay(10, TimeUnit.SECONDS)
                .build()

            WorkManager.getInstance(context).enqueue(request)
        }) {
            Text(text = "Execute2")
        }
    }
}

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