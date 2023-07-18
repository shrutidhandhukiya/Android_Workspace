package com.example.project.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Activity.CategoryProductActivity
import com.example.project.Model.CategoryModel
import com.example.project.R
import com.squareup.picasso.Picasso

class CategoryAdapter(var context: Context, var mutableList: MutableList<CategoryModel>):RecyclerView.Adapter<MyView1>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView1 {

        var view = LayoutInflater.from(context).inflate(R.layout.raw_category_design,parent,false)
        return  MyView1(view)
    }

    override fun getItemCount(): Int {

        return mutableList.size
    }

    override fun onBindViewHolder(holder: MyView1, position: Int) {

        Picasso.with(context).load(mutableList[position].image).into(holder.dashboard_img)
        holder.tvTitle.text = mutableList[position].name

       holder.itemView.setOnClickListener {

           var i = Intent(context,CategoryProductActivity::class.java)
               i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

           //i.putExtra("imageurl",mutableList.get(position).image)
                context.startActivity(i)
       }
    }
}
class MyView1(itemview:View):RecyclerView.ViewHolder(itemview){

    var dashboard_img :ImageView = itemview.findViewById(R.id.dashboard_img)
    var tvTitle:TextView = itemview.findViewById(R.id.tvTitle)
}
