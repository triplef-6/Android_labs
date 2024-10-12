package com.example.natashayoureasleep

import android.os.Bundle
import android.widget.ImageView
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

        val secondText: TextView = findViewById(R.id.textView)
        val thirdText: TextView = findViewById(R.id.textView2)
        val forthText: TextView = findViewById(R.id.textView3)
        val rightBottomImage: ImageView = findViewById(R.id.imageView2)

        rightBottomImage.setOnClickListener {
            val phrases = listOf(
                "Вставай, мы там всё уронили",
                "Мы уронили вообще всё, Наташ, честно",
                "Я съел цветок",
                "ЖРАТЬ ЖРАТЬ ЖРАТЬ")

            val shuffledList = phrases.shuffled() // перемешанный список

            secondText.text = shuffledList[0]
            thirdText.text = shuffledList[1]
            forthText.text = shuffledList[2]
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}