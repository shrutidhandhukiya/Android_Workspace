package com.example.sqliteactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class UpdateActivity : AppCompatActivity() {

    lateinit var edt1: EditText
    lateinit var edt2: EditText
    lateinit var btn1: Button
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        dbHelper = DbHelper(applicationContext)

        var i = intent
        var id = i.getIntExtra("id", 101)
        var name = i.getStringExtra("name")
        var num = i.getStringExtra("num")

        edt1.setText(name)
        edt2.setText(num)
        Toast.makeText(applicationContext, "" + id, Toast.LENGTH_LONG).show()
        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var num = edt2.text.toString()

            var m = Model()
            m.id = id
            m.name = name
            m.num = num

            dbHelper.updatedata(m)
            startActivity(Intent(applicationContext, MainActivity2::class.java))
        }
    }
}