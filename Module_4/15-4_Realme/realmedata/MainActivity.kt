package com.example.realmedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.realmedata.databinding.ActivityMainBinding
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        realm =Realm.getInstance(Realm.getDefaultConfiguration()!!)

         binding.btn1.setOnClickListener {

             var name1 = binding.edt1.text.toString()
             var pass2 = binding.edt2.text.toString()

             //transction start kru
             realm.beginTransaction()
             var m = realm.createObject(Model::class.java)
             m.name = name1
             m.name= pass2

             realm.commitTransaction()

             Toast.makeText(applicationContext,"Insert record",Toast.LENGTH_SHORT).show()
           }

        binding.btn2.setOnClickListener {

            startActivity(Intent(applicationContext,ViewActivity::class.java))
        }

    }
}