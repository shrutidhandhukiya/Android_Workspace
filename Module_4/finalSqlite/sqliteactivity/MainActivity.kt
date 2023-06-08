package com.example.sqliteactivity

import android.content.Intent
import android.graphics.ColorSpace.Model
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var editText:EditText
    lateinit var  edittx :EditText
    lateinit var  btn1 :Button
    lateinit var  btn2 :Button
    private lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edittx = findViewById(R.id.edittx)
        editText =  findViewById(R.id.editText)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        dbHelper = DbHelper(applicationContext)

            btn1.setOnClickListener {

                var  name = editText.text.toString()
                var num = edittx.text.toString()

                var m = Model()
                m.name = name
                m.num = num

                var id = dbHelper.savedata(m)
                Toast.makeText(applicationContext, "Record inserted$id",Toast.LENGTH_LONG).show()
            }

        btn2.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }
    }
}