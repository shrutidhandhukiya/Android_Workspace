package com.example.customtoastcustomdialong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var linerLayout: LinearLayout
    lateinit var  txt1 :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main2)

        linerLayout= LinearLayout(this)
        txt1= TextView(this)
        txt1.setText("Hello World  ")
        txt1.width= 100
        txt1.height= 100
        linerLayout.addView(txt1)
        setContentView(linerLayout)

    }
}