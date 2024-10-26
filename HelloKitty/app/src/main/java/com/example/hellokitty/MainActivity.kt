package com.example.hellokitty

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mHelloTextView: TextView
    private lateinit var editText: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mHelloTextView = findViewById(R.id.textView)
        var imageButton: ImageButton = findViewById(R.id.imageButton)

        val textView: TextView = findViewById(R.id.textView)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }
        val botton2: Button = findViewById(R.id.button2)
        botton2.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }

        imageButton.setOnClickListener {
            mHelloTextView.setText("Hello Kitty")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editText = findViewById(R.id.editTextText)

        imageButton.setOnClickListener {
            if (editText.text.isEmpty()) {
                mHelloTextView.text = "Hello Kitty!";
            } else {
                mHelloTextView.text = "Привет, " + editText.text
            }
        }
    }
}