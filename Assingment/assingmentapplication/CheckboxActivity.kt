package com.example.assingmentapplication

import android.annotation.SuppressLint
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast

class CheckboxActivity : AppCompatActivity() {

    lateinit var check1: CheckBox
    lateinit var check2: CheckBox
    lateinit var txt1: TextView
    lateinit var  btn:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        check1 = findViewById(R.id.check1)
        check2 = findViewById(R.id.check2)
        txt1 = findViewById(R.id.txt1)
        btn = findViewById(R.id.btn)

        check1.setOnCheckedChangeListener { compoundButton, b ->
            if (check1.isChecked) {

                Toast.makeText(applicationContext, "Checked", Toast.LENGTH_SHORT).show()
                txt1. visibility = View.VISIBLE
            }
            else if (!check1.isChecked)
            {
                Toast.makeText(applicationContext, "UnChecked", Toast.LENGTH_SHORT).show()
                txt1. visibility = View.INVISIBLE
            }
        }
    }
}



