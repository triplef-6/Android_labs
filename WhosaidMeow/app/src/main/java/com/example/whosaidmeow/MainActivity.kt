package com.example.whosaidmeow

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var soundPool: SoundPool
    private lateinit var assetManager: AssetManager

    private var catSound: Int = 0
    private var horseSound: Int = 0
    private var pigSound: Int = 0
    private var dogSound: Int = 0
    private var dolphinSound: Int = 0
    private var bearSound: Int = 0

    private var streamID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val catImage: ImageView = findViewById(R.id.image_cat)
        val horseImage: ImageView = findViewById(R.id.image_horse)
        val pigImage: ImageView = findViewById(R.id.image_pig)
        val dogImage: ImageView = findViewById(R.id.image_dog)
        val dolphinImage: ImageView = findViewById(R.id.image_dolphin)
        val bearImage: ImageView = findViewById(R.id.image_bear)

        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setAudioAttributes(attributes)
            .build()

        assetManager = assets
        catSound = loadSound("cat_sound.mp3")
        horseSound = loadSound("horse_sound.mp3")
        pigSound = loadSound("pig_sound.mp3")
        dogSound = loadSound("dog_sound.mp3")
        dolphinSound = loadSound("dolphin_sound.mp3")
        bearSound = loadSound("bear_sound.mp3")

        catImage.setOnClickListener { playSound(catSound) }
        horseImage.setOnClickListener { playSound(horseSound) }
        pigImage.setOnClickListener { playSound(pigSound) }
        dogImage.setOnClickListener { playSound(dogSound) }
        dolphinImage.setOnClickListener { playSound(dolphinSound) }
        bearImage.setOnClickListener { playSound(bearSound) }


    }

    private fun loadSound(fileName: String): Int {
        val afd: AssetFileDescriptor = try {
            application.assets.openFd(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
            Log.d("Meow", "Не могу загрузить файл $fileName")

            return -1
        }
        return soundPool.load(afd, 1)
    }

    override fun onPause() {
        super.onPause()

        soundPool.release()
    }

    private fun playSound(sound: Int): Int {
        if (sound > 0) {
            streamID = soundPool.play(sound, 1F, 1F, 1, 0, 1F)
        }
        return streamID
    }
}