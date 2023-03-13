package com.example.checkbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class loginActivity : AppCompatActivity() {

    lateinit var  edText:EditText
    lateinit var edText1:EditText
    lateinit var btn:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edText = findViewById(R.id.edText)
        edText1= findViewById(R.id.edText1)
        btn= findViewById(R.id.btn)

        btn.setOnClickListener {

            var m = edText.text.toString()
            var n =  edText1.text.toString()


            if (m.equals("9104046331") && n.equals("12345"))
            {

                startActivity(Intent(applicationContext,HomeActivity::class.java))
            }
            else
            {
                Toast.makeText(applicationContext,"login Failed",Toast.LENGTH_SHORT).show()
            }

        }

    }
}