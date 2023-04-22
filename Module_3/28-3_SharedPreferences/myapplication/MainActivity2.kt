package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE)

       // Toast.makeText(applicationContext,"WELCOME"+sharedPreferences.getString("NAME",""),Toast.LENGTH_LONG).show()
    }
}