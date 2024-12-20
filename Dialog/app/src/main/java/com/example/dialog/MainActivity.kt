package com.example.dialog

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val myDialogFragment = MyDialogFragment()
            val manager = supportFragmentManager
            myDialogFragment.show(manager, "myDialog")
        }
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val myDialogFragment2 = MyDialogFragment2()
            val manager = supportFragmentManager
            myDialogFragment2.show(manager, "myDialog2")
        }
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val myDialogFragment3 = MyDialogFragment3()
            val manager = supportFragmentManager
            myDialogFragment3.show(manager, "myDialog3")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}