package com.example.assingmentapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

@Suppress("UNUSED_CHANGED_VALUE")
class IncreatePlus : AppCompatActivity() {

    lateinit var  btnPlus:Button
    lateinit var btnMinus: Button
    lateinit var  tvTest :TextView

    var increment_number = 1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_increate_plus)

        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        tvTest = findViewById(R.id.tvTest)

        btnPlus.setOnClickListener {

             increment_number++

            tvTest.setTextSize(increment_number.toFloat())


        }
        btnMinus.setOnClickListener {

            increment_number--

            tvTest.setTextSize(increment_number.toFloat())
        }
    }
}