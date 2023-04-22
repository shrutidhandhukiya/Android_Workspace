package com.example.drawerapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter (var context: Context, var list: MutableList<Model>):BaseAdapter() {
    override fun getCount(): Int {
      return  list.size
    }

    override fun getItem(p0: Int): Any {
        return  p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.desing,p2,false)

        var txt1:TextView = view.findViewById(R.id.txt1)
        var img:ImageView = view.findViewById(R.id.img)
        var tvProductPrice:TextView = view.findViewById(R.id.tvProductPrice)

        txt1.setText(list.get(p0).name)
        img.setImageResource(list.get(p0).img)


        return view
    }
}