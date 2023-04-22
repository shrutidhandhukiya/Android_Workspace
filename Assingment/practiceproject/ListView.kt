package com.example.practiceproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.practiceproject.ListView as ListView1

class ListView : AppCompatActivity() {

    lateinit var  listView: ListView1
    lateinit var  list: MutableList<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)


        list = ArrayList()

        list.add("wklgnk")
        list.add("wklgnk")
        list.add("wklgnk")
        list.add("wklgnk")
    }

    var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)

}