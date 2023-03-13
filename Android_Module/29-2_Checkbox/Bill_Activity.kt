
package com.example.checkbox

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Bill_Activity : AppCompatActivity() {

   lateinit var  tvTextView:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill)

        tvTextView = findViewById(R.id.tvTextView)

       var i = intent

        var data = i.getStringExtra("BILL")
        tvTextView.setText(data)
    }
}