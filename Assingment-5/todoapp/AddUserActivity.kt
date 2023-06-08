package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.databinding.ActivityAddUserBinding
import com.example.todoapp.databinding.ActivityMainBinding

class AddUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddUserBinding
    lateinit var  dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)

        binding.btn1.setOnClickListener {

            var task = binding.edit1.text.toString()
            var des = binding.edit2.text.toString()

            var m = Model()
            m.task = task
            m.des = des

            var id = dbHelper.savedata(m)

            Toast.makeText(applicationContext, "Record insert$id", Toast.LENGTH_SHORT).show()

            startActivity(Intent(applicationContext,MainActivity::class.java))

        }



    }
}