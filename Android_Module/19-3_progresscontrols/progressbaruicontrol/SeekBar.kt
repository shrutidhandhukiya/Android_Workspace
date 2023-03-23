package com.example.progressbaruicontrol

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast

import com.example.progressbaruicontrol.databinding.ActivitySeekBarBinding

class SeekBar : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var bindings: ActivitySeekBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivitySeekBarBinding.inflate(layoutInflater)
        val view = bindings.root
        setContentView(view)

        bindings.seek1.setOnSeekBarChangeListener(this)
        bindings.seek2.setOnSeekBarChangeListener(this)
        bindings.seek3.setOnSeekBarChangeListener(this)
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

         val r = bindings.seek1.progress
         val g = bindings.seek2.progress
         val b =  bindings.seek3.progress

        bindings.img.setBackgroundColor(Color.rgb(r,g,b))


    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }
}