package com.example.assingmentapplication

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup

class RedioButtonActivity : AppCompatActivity() {

   lateinit var  liner :LinearLayout
    lateinit var  rvRadioBtn1:RadioButton
    lateinit var rvRadioBtn2:RadioButton
    lateinit var  rg :RadioGroup

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redio_button)

        liner = findViewById(R.id.liner)
        rg = findViewById(R.id.rg)
        rvRadioBtn1 = findViewById(R.id.rvRadioBtn1)
        rvRadioBtn2 = findViewById(R.id.rvRadioBtn2)

        rg.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->


            when(i){
              R.id.rvRadioBtn1 ->
              {

              liner.setBackgroundColor(Color.BLUE)
              }
                R.id.rvRadioBtn2 ->
                {
                    liner.setBackgroundColor(Color.RED)
                }
            }
        })

    }
}