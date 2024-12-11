package com.example.crowcounter

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val APP_PREFERENCES_COUNTER = "counter"
    private var counter: Int = 0
    private lateinit var prefs: SharedPreferences

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        prefs =
            getSharedPreferences("settings", Context.MODE_PRIVATE)

        val textView: TextView = findViewById(R.id.textView)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            textView.text = "Hello!"
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button_counter: Button = findViewById(R.id.button_counter)
        button_counter.setOnClickListener {
            textView.text = "Я насчитал ${++counter} ворон"
        }

        val button_counter_clean: Button = findViewById(R.id.button_counter_clean)
        button_counter_clean.setOnClickListener {
            counter = 0
            textView.text = "Я насчитал ${counter} ворон"
        }
    }

    override fun onPause() {
        super.onPause()

        val editor = prefs.edit()
        editor.putInt(APP_PREFERENCES_COUNTER, counter).apply()
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()

        if (prefs.contains(APP_PREFERENCES_COUNTER)) {
            counter = prefs.getInt(APP_PREFERENCES_COUNTER, 0)

            val textView: TextView = findViewById(R.id.textView)
            textView.text = "Я насчитал ${counter} ворон"
        }
    }
}