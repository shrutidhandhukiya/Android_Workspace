package com.example.project.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.project.Activity.CategoryProductActivity
import com.example.project.Activity.FullScreenImageActivity
import com.example.project.Model.CategoryProduct
import com.example.project.R
import com.squareup.picasso.Picasso


class CategoryProductAdapter(var context: Context, var list: MutableList<CategoryProduct>):RecyclerView.Adapter<MyView2>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView2 {
      var view = LayoutInflater.from(context).inflate(R.layout.raw_categoryproduct,parent,false)
        return MyView2(view)
    }

    override fun getItemCount(): Int
    {
      return  list.size
    }

    override fun onBindViewHolder(holder: MyView2, position: Int) {

        Picasso.with(context).load(list.get(position).productimage).into(holder.productImg)
        holder.productTitle.text = list.get(position).productname
        holder.productPrice.text = list.get(position).productprice

        holder.itemView.setOnClickListener {

            var i = Intent(context,FullScreenImageActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("imageurl",list.get(position).productimage)
            context.startActivity(i)



        }
    }
}

class MyView2(itemview: View):RecyclerView.ViewHolder(itemview) {

     var productImg:ImageView = itemview.findViewById(R.id.productImg)
     var productTitle:TextView = itemview.findViewById(R.id.productTitle)
     var productPrice:TextView = itemview.findViewById(R.id.productPrice)

}
