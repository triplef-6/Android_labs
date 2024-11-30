package com.example.converter

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.i("MainActivity", "onCreate() called")

        val meterRadioButton: RadioButton = findViewById(R.id.radio_button_meter)
        val inputEditText: EditText = findViewById(R.id.editText)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            if (inputEditText.text.isEmpty()) {
                Toast.makeText(
                    applicationContext, "Введите длину кота",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val inputValue = inputEditText.text.toString().toFloat()
                if (meterRadioButton.isChecked) {
                    inputEditText.setText(convertParrotToMeter(inputValue).toString())
                } else {
                    inputEditText.setText(convertMeterToParrot(inputValue).toString())
                }
            }
        }

    }
    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy() called")
    }

    // Конвертируем в метры
    private fun convertParrotToMeter(parrot: Float): Float = (parrot / 7.6).toFloat()

    // Конвертируем в попугаи
    private fun convertMeterToParrot(meter: Float): Float = (meter * 7.6).toFloat()
}