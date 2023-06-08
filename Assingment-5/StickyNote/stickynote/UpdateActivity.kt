package com.example.stickynote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stickynote.databinding.ActivityMainBinding
import com.example.stickynote.databinding.ActivityUpdateBinding

class
UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    lateinit var dbHelper:DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)

        var i = intent

        var id = i.getIntExtra("id", 101)
        var name = i.getStringExtra("title")
        var num = i.getStringExtra("des")

        binding.edit1.setText(name)
        binding.edit2.setText(num)

        Toast.makeText(applicationContext, ""+id , Toast.LENGTH_LONG).show()

        binding.btn.setOnClickListener {

            var title = binding.edit1.text.toString()
            var des = binding.edit2.text.toString()

            var m = Model()
            m.id = id
            m.title = title
            m.des = des

            dbHelper.updatedata(m)
            startActivity(Intent(applicationContext, MainActivity::class.java))

        }

    }

}
