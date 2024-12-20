package com.example.threeactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

//        button.setOnClickListener {
//            val intent = Intent(this@MainActivity, FirstActivity::class.java)
//            startActivity(intent)
//        }
        val button: Button = findViewById(R.id.button1)
        val edit_address: TextView = findViewById(R.id.edit_address)
        val edit_gift: TextView = findViewById(R.id.edit_gift)

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("username", edit_address.text.toString())
            intent.putExtra("gift", edit_gift.text.toString())
            startActivity(intent)
        }
//        val button2: Button = findViewById(R.id.button2)
//        button2.setOnClickListener {
//            val intent = Intent(this@MainActivity, SecondActivity::class.java)
//            startActivity(intent)
//        }
    }
}