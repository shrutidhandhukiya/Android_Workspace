package com.example.jsonfromattask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso

class MyAdapter(var context: Context , var list: MutableList<Model>):RecyclerView.Adapter<MyView>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.desing_layout,parent,false)
        return  MyView(view)

    }

    override fun onBindViewHolder(holder: MyView, position: Int) {

      holder.tvText1.setText(list.get(position).name)
        holder.tvText2.setText(list.get(position).relName)
        holder.tvText3.setText(list.get(position).team)
        holder.tvText4.setText(list.get(position).firstApperiance)
        holder.tvText5.setText(list.get(position).createBy)
        holder.tvText6.setText(list.get(position).publish)


     Picasso.get().load(list.get(position).image).placeholder(R.mipmap.ic_launcher).into(holder.image)



    }

    override fun getItemCount(): Int {

       return list.size
    }


}

class MyView(itemview : View)  : RecyclerView.ViewHolder(itemview){


    var tvText1 :TextView = itemview.findViewById(R.id.tvText1)
    var tvText2 :TextView = itemview.findViewById(R.id.tvText2)
    var tvText3:TextView = itemview.findViewById(R.id.tvText3)
    var tvText4 :TextView = itemview.findViewById(R.id.tvText4)
    var tvText5 :TextView = itemview.findViewById(R.id.tvText5)
    var tvText6 :TextView = itemview.findViewById(R.id.tvText6)
    var image : ImageView = itemview.findViewById(R.id.image)


}
