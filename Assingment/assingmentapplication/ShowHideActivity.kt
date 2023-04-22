package com.example.assingmentapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

class ShowHideActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var tvText: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_hide)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        tvText = findViewById(R.id.tvText)



        btn1.setOnClickListener {

            tvText.visibility = View.INVISIBLE

                Toast.makeText(applicationContext, "Text is Hidden ", Toast.LENGTH_SHORT).show()
        }
        btn2.setOnClickListener {

            tvText.visibility = View.VISIBLE

            Toast.makeText(applicationContext, "Text is Show ", Toast.LENGTH_SHORT).show()
        }

    }
}
