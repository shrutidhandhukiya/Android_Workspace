package com.example.stickynote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stickynote.databinding.ActivityMainBinding

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
        binding.recycler.layoutManager = manager


        var adapter = MyAdapter(list)
       binding.recycler.adapter = adapter

        binding.floating.setOnClickListener {

            startActivity(Intent(applicationContext,AddStickyNote::class.java))
        }




    }
}