package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var  list: MutableList<Model>
    lateinit var  dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()
        dbHelper =  DbHelper(applicationContext)
        list =dbHelper.viewdata()

        var manager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.rvRecycler.layoutManager = manager

        var adapter = MyAdapter(this,list)
        binding.rvRecycler.adapter = adapter


        binding.f1.setOnClickListener {

            startActivity(Intent(applicationContext, AddUserActivity::class.java))

        }

    }

    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }
}