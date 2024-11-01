package com.example.threeactivities

import android.app.Activity
import android.os.Bundle

class FirstActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first)
    }
}