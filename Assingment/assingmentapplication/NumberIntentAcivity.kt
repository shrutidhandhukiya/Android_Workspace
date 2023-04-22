package com.example.assingmentapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class NumberIntentAcivity : AppCompatActivity() {

    lateinit var tvText:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_intent_acivity)

        tvText = findViewById(R.id.tvText)

        val i = intent
        tvText.text = i.getStringExtra("data")


    }
}