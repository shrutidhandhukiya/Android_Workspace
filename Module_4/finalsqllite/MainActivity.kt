package com.example.finalsqllite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finalsqllite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


     lateinit var  dbHelper: DbHelper
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

         dbHelper = DbHelper(applicationContext)

        binding.btn1.setOnClickListener {

             var name = binding.edt1.text.toString()
             var num = binding.edt2.text.toString()

            var m = Model()
            m.name = name
            m.num = num

            val id = dbHelper.savedata(m)
            Toast.makeText(applicationContext, "Insert record$id",Toast.LENGTH_SHORT).show()

        }

    }
}