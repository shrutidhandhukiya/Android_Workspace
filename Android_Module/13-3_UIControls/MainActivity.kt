package com.example.uicontrols

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var radioGroup:RadioGroup
    lateinit var rvRadioBtn1: RadioButton
    lateinit var rvRadioBtn2: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        rvRadioBtn1= findViewById(R.id.rvRadioBtn1)
        rvRadioBtn2= findViewById(R.id.rvRadioBtn2)

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->

            when(i)
            {
                R.id.rvRadioBtn1 ->

                    Toast.makeText(this,"Female",Toast.LENGTH_LONG).show()

                R.id.rvRadioBtn2 ->
                {
                    Toast.makeText(this,"Male",Toast.LENGTH_LONG).show()
                }

            }


        }





    }
}