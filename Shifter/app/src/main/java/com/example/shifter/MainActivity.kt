package com.example.shifter

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.view.Surface
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val text: TextView = findViewById(R.id.editText)

        button1.setOnClickListener {
            text.setText("Кнопка 1:" + getScreenOrientation() + ":" + getRotateOrientation())
        }
        button2.setOnClickListener {
            text.setText("Кнопка 2:" + getScreenOrientation() + ":" + getRotateOrientation())
        }
        button3.setOnClickListener {
            text.setText("Кнопка 3:" + getScreenOrientation() + ":" + getRotateOrientation())
        }
        button4.setOnClickListener {
            text.setText("Кнопка 4:" + getScreenOrientation() + ":" + getRotateOrientation())
        }
        button5.setOnClickListener {
            text.setText("Кнопка 5:" + getScreenOrientation() + ":" + getRotateOrientation())
        }
        button6.setOnClickListener {
            text.setText("Кнопка 6:" + getScreenOrientation() + ":" + getRotateOrientation())
        }








    }

    private fun getScreenOrientation(): String {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> "Портретная ориентация"
            Configuration.ORIENTATION_LANDSCAPE -> "Альбомная ориентация"
            else -> ""
        }
    }

    private fun getRotateOrientation(): String {
        return when (windowManager.defaultDisplay.rotation) {
            Surface.ROTATION_0 -> "Не поворачивали"
            Surface.ROTATION_90 -> "Повернули на 90 градусов по часовой стрелке"
            Surface.ROTATION_180 -> "Повернули на 180 градусов"
            Surface.ROTATION_270 -> "Повернули на 90 градусов против часовой стрелки"
            else -> "Не понятно"
        }
    }
}