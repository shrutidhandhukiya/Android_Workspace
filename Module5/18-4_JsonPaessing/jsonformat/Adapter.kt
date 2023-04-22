package com.example.jsonformat

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class Adapter(var context: Context, var list: MutableList<Model>): BaseAdapter(){
    override fun getCount(): Int {
       return list.size
    }

    override fun getItem(p0: Int): Any {
       return  list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
       return  p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.raw_desing_layout,p2,false)


        var text1 : TextView = view.findViewById(R.id.text1)
        var text2 :TextView = view.findViewById(R.id.text2)
        var text3: TextView  =  view.findViewById(R.id.text3)
        var image :ImageView = view.findViewById(R.id.image1)

        text1.setText(list.get(p0).name)
        text2.setText(list.get(p0).price)
        text3.setText(list.get(p0).des)

        Picasso.get().load(list.get(p0).image).into(image)

        return  view
    }


}