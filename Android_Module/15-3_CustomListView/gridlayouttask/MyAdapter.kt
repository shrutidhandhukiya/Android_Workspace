package com.example.gridlayouttask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.Collections.list

class MyAdapter(var context: Context , var  list: MutableList<Mdel>):BaseAdapter()
{
    override fun getCount(): Int {

        return  list.size
    }

    override fun getItem(p0: Int): Any {
       return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.raw_design_layout,p2,false)

      var image :ImageView = view.findViewById(R.id.image)
      var text: TextView = view.findViewById(R.id.text)

      image.setImageResource(list.get(p0).image)
      text.setText(list.get(p0).name)

      return  view


    }
}