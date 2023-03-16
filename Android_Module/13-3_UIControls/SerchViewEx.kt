package com.example.uicontrols

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView

class SerchViewEx : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var searchView: SearchView
    lateinit var list: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serch_view_ex)

      listView = findViewById(R.id.list2)
        searchView = findViewById(R.id.search)

        list = ArrayList()

        list.add("Android ")
        list.add("Java")
        list.add("Python")
        list.add("Kotlin")
        list.add("Java")

        var adapter = ArrayAdapter<String>(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter = adapter


         searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{

             override fun onQueryTextSubmit(p0: String?): Boolean {
                 return false
             }

             override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                 return true
             }


         })



    }
}