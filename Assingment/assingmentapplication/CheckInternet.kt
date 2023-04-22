package com.example.assingmentapplication

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class CheckInternet : AppCompatActivity() {

    lateinit var btn1: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_internet)

        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            if (isNetworkConnected())
            {

                Toast.makeText(applicationContext,"Network is Connected",Toast.LENGTH_SHORT).show()
            }
            else
            {
              Toast.makeText(applicationContext,"DiesConnected " , Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isNetworkConnected():Boolean {

       // var cm1 = applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val cm = applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
       return cm.activeNetworkInfo != null

    }




}

