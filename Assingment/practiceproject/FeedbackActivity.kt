package com.example.practiceproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practiceproject.databinding.ActivityFeedbackBinding

class FeedbackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.edtname.setText("shruti")
        binding.edtsurname.setText("Dhandhukiya ")


    }
}