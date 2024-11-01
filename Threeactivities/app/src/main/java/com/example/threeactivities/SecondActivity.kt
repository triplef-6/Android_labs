package com.example.threeactivities

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class SecondActivity: Activity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
//        val user = "ЖЫвотное"
//        val gift = "дырку от бублика"
        val user = intent.extras?.getString("username")
        val gift = intent.extras?.getString("gift")

        val textView: TextView = findViewById(R.id.textview_second_info)
        textView.text = "$user, вам передали $gift"
    }
}