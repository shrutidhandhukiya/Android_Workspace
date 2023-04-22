package com.example.assingmentapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.lang.String
import kotlin.Int

class NumberActivity : AppCompatActivity() {

    lateinit var  edit1:EditText
    lateinit var  edit2:EditText
    lateinit var  btn :Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)

        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {

          //  var n1 = edit1.text.toString().toInt()

           val num = String.valueOf(edit1.text).toInt()
            val nu1 = String.valueOf(edit2.text).toInt()

            val sb = StringBuilder(num.toString())
            for (i in num + 1..nu1) {
                sb.append(", ").append(i)
            }

            val i = Intent(applicationContext, NumberIntentAcivity::class.java)
            i.putExtra("data", sb.toString())
            startActivity(i)







        }


        }
    }
