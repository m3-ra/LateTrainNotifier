package com.jcros.latetrainnotifier.notifications

import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import com.jcros.latetrainnotifier.R
import java.util.*

class NotifierManager(private val alarmManager: AlarmManager, private val notificationManager: NotificationManager,
                      @field:Transient private val context: Context) {

    fun start(id: Int) {

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.add(Calendar.MINUTE, 1)
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, "", { sendNotification(id) }, null)
    }

    private fun sendNotification(id: Int) {

        val channel = NotificationChannel("666", "latetrainnotifier", NotificationManager.IMPORTANCE_DEFAULT)

        notificationManager.createNotificationChannel(channel)

        val not = Notification.Builder(context, "666").setContentTitle("titre!").setContentText(id.toString())
                .setSmallIcon(R.drawable.ic_launcher_background).build()
        notificationManager.notify(0, not)
    }
}