package com.example.gusports.pushnotification

import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import com.example.gusports.ui.activities.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class PushNotificationService:FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("TOKETN", "onNewToken: $token")


    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        addNotification(message.notification!!.title, message.notification!!.body)
    }


    private fun addNotification(title:String?,body:String?) {
        lateinit var notificationChannel: NotificationChannel
        lateinit var builder: Notification.Builder
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        var notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = NotificationChannel("guapps", "Notifications", NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, "guapps")
                .setSmallIcon(R.drawable.ic_notification_clear_all)
                .setContentTitle(title)
                .setContentText(body)
                .setContentIntent(pendingIntent)
        } else {

            builder = Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_notification_clear_all)
                .setContentTitle(title)
                .setContentText(body)
                .setContentIntent(pendingIntent)
        }
        notificationManager.notify(1234, builder.build())
    }

}