
package com.example.playsong

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.playsong.databinding.ActivityMainBinding
import com.example.playsong.databinding.ActivityServerSongPlayBinding
import java.net.URL

class ServerSongPlay : AppCompatActivity(), MediaPlayer.OnPreparedListener {

    private lateinit var binding: ActivityServerSongPlayBinding
    lateinit var mediaPlayer: MediaPlayer

    var url = "https://shruti76.000webhostapp.com/song/01%20Aaj%20Se%20Teri%20-%20Padman%20(Arijit%20Singh)%20320Kbps.mp3"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServerSongPlayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    binding.btn1.setOnClickListener {

        mediaPlayer.setDataSource(url)
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener(this)
        mediaPlayer.start()

    }
        binding.btn3.setOnClickListener {

            mediaPlayer.stop()

        }


    }

    override fun onPrepared(p0: MediaPlayer?) {
        mediaPlayer.start()
    }
}