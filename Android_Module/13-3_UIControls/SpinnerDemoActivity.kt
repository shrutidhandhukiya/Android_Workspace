package com.example.uicontrols

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class SpinnerDemoActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var  spin :Spinner
    var cityarry = arrayOf("surat ","Rajkot","Dhari")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_demo)

        spin = findViewById(R.id.spin)

         var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,cityarry)
        spin.adapter = adapter

        spin.setOnItemSelectedListener(this)

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        Toast.makeText(applicationContext,""+cityarry[p2],Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}