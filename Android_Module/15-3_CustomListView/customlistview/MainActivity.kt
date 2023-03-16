package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

     lateinit var  listView: ListView

     lateinit var  list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        list.add(Model(R.drawable.img1,"Coffee"))
        list.add(Model(R.drawable.img1,"Coffee"))
        list.add(Model(R.drawable.img1,"Coffee"))
        list.add(Model(R.drawable.img1,"Coffee"))


        var  adapter = MyAdapter(applicationContext,list)

        listView.adapter = adapter



    }



}