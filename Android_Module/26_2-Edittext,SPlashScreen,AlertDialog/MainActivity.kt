package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edText: EditText
    lateinit var edText1: EditText
    lateinit var btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edText = findViewById(R.id.edText)
        edText1 = findViewById(R.id.edText1)
        btn = findViewById(R.id.btn)


        //validation
        btn.setOnClickListener {

            var n = edText.text.toString()
            var p = edText1.text.toString()

            if(n.length==0 && p.length==0)
            {
                edText.setError("Please Enter Name")
                edText1.setError("Please Enter Password")
            }
            else if(n.length==0)
            {
                edText.setError("Please Enter Name")
            }
            else if(p.length==0)
            {
                edText1.setError("Please Enter Password")
            }
            else
            {
                if (n.equals("tops") && p.equals("12345"))
                {
                    Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
                }

                else
                {
                    Toast.makeText(applicationContext,"Your Credentials are Wrong",Toast.LENGTH_LONG).show()
                }

            }
        }

    }





}