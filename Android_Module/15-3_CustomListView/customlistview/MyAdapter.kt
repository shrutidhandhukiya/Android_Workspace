package com.example.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var context:Context, var list: MutableList<Model>):BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.desing,p2,false)

        var imageView :ImageView = view.findViewById(R.id.image)
        var textView:TextView = view.findViewById(R.id.txt1)


         imageView.setImageResource(list[p0].imageView)
         textView.setText(list[p0].name)


        return  view
    }
}