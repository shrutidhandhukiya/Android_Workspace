package com.example.playsong

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.playsong.databinding.ActivityServerSongPlayBinding
import com.example.playsong.databinding.ActivityVideoPlayBinding

class videoPlay : AppCompatActivity() {

    private lateinit var binding: ActivityVideoPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var mediaController  = MediaController(this)
        mediaController.setAnchorView(binding.video)

        var video: Uri = Uri.parse("https://shruti76.000webhostapp.com/song/77ef83e758f89a76fdfd688639eb62db.mp4")
        binding.video.setMediaController(mediaController)
        binding.video.setVideoURI(video)
        binding.video.start()
    }
}