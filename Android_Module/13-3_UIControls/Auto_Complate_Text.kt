package com.example.uicontrols

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class Auto_Complate_Text : AppCompatActivity() {

    lateinit var autoText:AutoCompleteTextView
    var array = arrayOf("rajkot", " dhari","Surat")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complate_text)

        autoText= findViewById(R.id.autoText)
        autoText.threshold = 3

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,array)
        autoText.setAdapter(adapter)
    }
}