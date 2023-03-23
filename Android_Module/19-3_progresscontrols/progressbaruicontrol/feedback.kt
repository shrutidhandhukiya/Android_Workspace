package com.example.progressbaruicontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.progressbaruicontrol.databinding.ActivityFeedbackBinding
import com.example.progressbaruicontrol.databinding.ActivityMainBinding

class feedback : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    binding.btn1.setOnClickListener {


    }
        binding.btn2.setOnClickListener {


        }


    }
}