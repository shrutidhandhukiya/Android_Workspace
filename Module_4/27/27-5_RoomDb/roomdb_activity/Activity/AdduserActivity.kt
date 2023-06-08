package com.example.roomdb_activity.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.roomdb_activity.DataBase.MyDb
import com.example.roomdb_activity.Entity.User
import com.example.roomdb_activity.MainActivity
import com.example.roomdb_activity.R
import com.example.roomdb_activity.databinding.ActivityAdduserBinding

class AdduserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdduserBinding
    var db:MyDb? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

     db =Room.databaseBuilder(applicationContext,MyDb::class.java,"myDatabase").allowMainThreadQueries().build()

    binding.btninsert.setOnClickListener {

        var name = binding.edtname.text.toString()
        var pass = binding.edtpass.text.toString()

        var m = User()
        m.name=name
        m.pass=pass


        db!!.daoClass().insertdata(m)
        Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()

    }

        binding.btnview.setOnClickListener {


            startActivity(Intent(applicationContext, MainActivity::class.java))

        }

    }
}