package com.example.broadcast

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        val WHERE_MY_CAT_ACTION: String = "com.example.action.CAT"
        val ALARM_MESSAGE: String = "Срочно пришлите кота!"
    }
    private val timeBroadcastReceiver = TimeBroadcastReceiver()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
//            val intent = Intent()
//            intent.action = WHERE_MY_CAT_ACTION
//            intent.putExtra("com.example.broadcast.Message", ALARM_MESSAGE)
//            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
//            sendBroadcast(intent)
            registerReceiver(
                timeBroadcastReceiver, IntentFilter(
                    "android.intent.action.TIME_TICK"
                ), RECEIVER_NOT_EXPORTED
            )
            Toast.makeText(
                getApplicationContext(), "Приёмник включен",
                Toast.LENGTH_SHORT
            ).show();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(timeBroadcastReceiver)
        Toast.makeText(
            getApplicationContext(),
            "Приёмник выключён", Toast.LENGTH_SHORT
        ).show();
    }
}