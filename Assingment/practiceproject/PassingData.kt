package com.example.practiceproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PassingData : AppCompatActivity() {

    lateinit var  txt:TextView
    lateinit var  txt1 :TextView

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passing_data)

        txt  = findViewById(R.id.txt)
        txt1 = findViewById(R.id.txt1)

     val i = intent
    val data = i.getStringExtra("NAME")
     val data1 =   i.getStringExtra("PASSWORD")

       txt.setText(data)
        txt1.setText(data1)
    }
}