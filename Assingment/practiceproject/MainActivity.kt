package com.example.practiceproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var  t1:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        t1 = findViewById(R.id.t1)

        // implicit
        t1.setOnClickListener {

            var uri = "https://www.flipkart.com/"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(uri))
            startActivity(i)


        }
    }
}