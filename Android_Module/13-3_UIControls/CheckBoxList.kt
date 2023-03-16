package com.example.uicontrols

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast


class CheckBoxList : AppCompatActivity() {

    lateinit var  ch1: CheckBox
    lateinit var  ch2: CheckBox
    lateinit var  ch3: CheckBox
    lateinit var  ch4:CheckBox
    lateinit var  ch5:CheckBox
    lateinit var  tvBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkbox_box_list)

        ch1  = findViewById(R.id.ch1)
        ch2  = findViewById(R.id.ch2)
        ch3  = findViewById(R.id.ch3)
        ch4 = findViewById(R.id.ch4)
        ch5 = findViewById(R.id.ch5)

        tvBtn = findViewById(R.id.ch5)

       ch1.setOnCheckedChangeListener { Button, b ->

           Toast.makeText(this,"Writing",Toast.LENGTH_SHORT).show()

       }
        ch2.setOnCheckedChangeListener { Button, b ->

            Toast.makeText(applicationContext,"Reading",Toast.LENGTH_SHORT).show()

        }
    }
}