package com.example.streetview

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val geoUriString = "geo:0.0?q=омск+клатбище&z=8"
            val geoUri: Uri = Uri.parse(geoUriString)
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            startActivity(mapIntent)
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            val geoUriString = "google.streetview:cbll=55.0278218,73.3153809&cbp=1,99.56,,1,2.0&mz=19"
            val geoUri: Uri = Uri.parse(geoUriString)
            val mapIntent = Intent(Intent.ACTION_VIEW, geoUri)
            startActivity(mapIntent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}