package com.example.notifications

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    private var counter = 101
    companion object {
        const val NOTIFICATION_ID = 666
        const val CHANNEL_ID = "channelID"
    }

    @SuppressLint("MissingPermission", "NotificationPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        createNotificationChannel()

        val intent = Intent(this, MainActivity::class.java)
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val button: Button = findViewById(R.id.button)

        val textView: TextView = findViewById(R.id.textView)
        button.setOnClickListener {
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(getString(R.string.reminder))
                .setContentText(getString(R.string.feed))
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setLargeIcon(
                    BitmapFactory.decodeResource(getResources(),
                    R.drawable.ic_action_cat_24dp))
                .setColor(Color.GREEN)

            with(NotificationManagerCompat.from(this)) {
                notify(counter++, builder.build())
            }

            textView.text = getString(R.string.feed)
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(getString(R.string.reminder))
                .setContentText(getString(R.string.pet))
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_MIN)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setLargeIcon(
                    BitmapFactory.decodeResource(getResources(),
                        R.drawable.ic_action_cat_24dp))
                .setColor(Color.YELLOW)


            with(NotificationManagerCompat.from(this)) {
                notify(counter++, builder.build())
            }

            textView.text = getString(R.string.pet)
        }

        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(getString(R.string.reminder))
                .setContentText(getString(R.string.clear))
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setLargeIcon(
                    BitmapFactory.decodeResource(getResources(),
                        R.drawable.ic_action_cat_24dp))
                .setColor(Color.RED)

            with(NotificationManagerCompat.from(this)) {
                notify(counter++, builder.build())
            }

            textView.text = getString(R.string.clear)
        }
    }


    private fun createNotificationChannel() { // что бы уведы запускались
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Main Channel"
            val descriptionText = "Channel for notifications"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}