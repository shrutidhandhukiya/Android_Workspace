package com.example.assingmentapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var  Btn1: Button
    lateinit var  Btn2: Button

    lateinit var  btn3:Button

    lateinit var  linearLayout: LinearLayout

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Btn1 = findViewById(R.id.Btn1)
        Btn2 = findViewById(R.id.Btn2)

        linearLayout = findViewById(R.id.liner)

        Btn1.setOnClickListener {
            linearLayout.setBackgroundColor(R.color.black)

        }
        Btn2.setOnClickListener {

            linearLayout.setBackgroundColor(R.color.purple_700)

        }
        btn3.setOnClickListener {

            var i = Intent(applicationContext,MainActivity2::class.java)
            i.putExtra("",toString())
            startActivity(i)
         }


    }
}