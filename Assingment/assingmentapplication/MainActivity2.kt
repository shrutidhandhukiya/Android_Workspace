package com.example.assingmentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var chk1: CheckBox
    lateinit var chk2: CheckBox
    lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)


        btn1.setOnClickListener {

            var amount = 0
            var builder = StringBuilder("")
            builder.append("\n selected Items \n")


            if (chk1.isChecked) {
                builder.append("\n Pizza @ Rs. 100 \n")
                amount += 100
            }
            if (chk2.isChecked) {
                builder.append("\n Burger @ Rs. 70 \n")
                amount += 70
            }

            var i = Intent(applicationContext,MainActivity3::class.java)
            i.putExtra("BILL",builder.toString())
            startActivity(i)
        }
    }
}