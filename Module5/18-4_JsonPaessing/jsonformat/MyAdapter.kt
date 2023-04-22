package com.example.jsonformat

import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MyAdapter(var context :Context , var list: MutableList<Model>):BaseAdapter() {

    override fun getCount(): Int {
        return  list.size
    }

    override fun getItem(p0: Int): Any {
        return  list.get(p0)
    }

    override fun getItemId(p0: Int): Long {

        return  p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.desing_layout,p2,false)

        var txt1:TextView = view.findViewById(R.id.txt1)
        var txt2:TextView = view.findViewById(R.id.txt2)
        var txt3:TextView = view.findViewById(R.id.txt3)
        var image:ImageView = view.findViewById(R.id.img)

        txt1.setText(list.get(p0).name)
        txt2.setText(list.get(p0).price)
        txt3.setText(list.get(p0).des)

       Picasso.get().load(list.get(p0).image).placeholder(R.mipmap.ic_launcher).into(image)

        return  view

    }


}