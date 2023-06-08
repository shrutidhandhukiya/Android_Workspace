package com.example.stickynote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.widget.Toast
import com.example.stickynote.databinding.ActivityAddStickyNoteBinding
import com.example.stickynote.databinding.ActivityMainBinding

class AddStickyNote : AppCompatActivity() {

    private lateinit var binding: ActivityAddStickyNoteBinding
    lateinit var  dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStickyNoteBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)


        binding.btn1.setOnClickListener {

            var title = binding.edit1.text.toString()
            var des = binding.edit2.text.toString()

            var m = Model()
            m.title = title
            m.des = des

            var id = dbHelper.savedata(m)

            Toast.makeText(applicationContext, "Record insert$id",Toast.LENGTH_SHORT).show()

            startActivity(Intent(applicationContext,MainActivity::class.java))
        }


    }

    override fun onBackPressed() {

        finishAffinity()

    }
}