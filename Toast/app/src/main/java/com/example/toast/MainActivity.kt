package com.example.toast

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val text = "Пора покормить кота!"
        val duration = Toast.LENGTH_SHORT
        val button1: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }
        button1.setOnClickListener {
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.CENTER, 0, 0)

            val toastContainer: LinearLayout = toast.view as LinearLayout
            val image = ImageView(this)

            image.setImageResource(R.drawable.persepolis)
            toastContainer.addView(image, 0)
            toast.show()
        }



    }
}