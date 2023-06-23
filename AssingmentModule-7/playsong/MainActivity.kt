package com.example.playsong

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.playsong.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.song)

        binding.btn1.setOnClickListener {

            mediaPlayer.start()

        /* var i = Intent(applicationContext,MyService::class.java)
            startService(i)*/
        }
        binding.btn2.setOnClickListener {



        }

            binding.btn3.setOnClickListener {

               /* var i = Intent(applicationContext,MyService::class.java)
                stopService(i)*/

                mediaPlayer.stop()

            }
        }
    }
