package com.example.gridlayouttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class MainActivity : AppCompatActivity() {

    lateinit var  gridView: GridView
    lateinit var  list: MutableList<Mdel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        gridView= findViewById(R.id.Grid1)
        list = ArrayList()

         list.add(Mdel(R.drawable.tea,"Coffee"))
         list.add(Mdel(R.drawable.franch,"Coffee"))
         list.add(Mdel(R.drawable.coffee,"Coffee"))
         list.add(Mdel(R.drawable.tea,"Coffee"))
         list.add(Mdel(R.drawable.tea,"Coffee"))
         list.add(Mdel(R.drawable.tea,"Coffee"))


        var adapter  =MyAdapter(applicationContext,list)
        gridView.adapter = adapter

    }
}