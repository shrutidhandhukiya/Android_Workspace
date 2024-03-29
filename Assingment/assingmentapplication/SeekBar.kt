package com.example.assingmentapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.assingmentapplication.databinding.ActivitySeekBarBinding

class SeekBar : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var binding: ActivitySeekBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.seek1.setOnSeekBarChangeListener(this)
        binding.seek2.setOnSeekBarChangeListener(this)
        binding.seek3.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

        var r =binding.seek1.progress
        var g = binding.seek2.progress
        var b = binding.seek3.progress


        binding.img.setBackgroundColor(Color.rgb(r,g,b))
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }


}



