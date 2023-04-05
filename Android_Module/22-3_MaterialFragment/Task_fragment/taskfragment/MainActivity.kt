package com.example.taskfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var  editText: EditText
    lateinit var  btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText= findViewById(R.id.editText)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            editText.text.toString()

            if (editText.length()== 0)
            {
                editText.setError("Please Enter your email.")
            }

            if (editText.equals("shruti") && btn1.isClickable)
            {

            }

            var n = NameFragment()
            var fm = supportFragmentManager
            var ft = fm.beginTransaction()
            ft.replace(R.id.fmid,n).commit()
        }
    }
}