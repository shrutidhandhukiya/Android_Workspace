package com.example.project.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.Model.HomeModel
import com.example.project.R
import com.squareup.picasso.Picasso


class HomeAdapter(var context: Context, var list: MutableList<HomeModel>):RecyclerView.Adapter<MyView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

      var view = LayoutInflater.from(context).inflate(R.layout.raw_desing_layout,parent,false)
        return MyView(view)
    }

    override fun getItemCount(): Int {
       return  list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {

        Picasso.with(context).load(list.get(position).image).into(holder.image)
        holder.text.text = list[position].name

       // holder.itemView.setOnClickListener {

         /*   var i = Intent(context,CategoriesFragment::class.java)
            i.putExtra("position ",position)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)*/


/*
            var c1 = CategoriesFragment()
            var fm =
            var ft = fm.beginTransaction()
            val bundle = Bundle()
            bundle.putInt("position", position)
            c1.setArguments(bundle)
            ft.replace(R.id.nav_host_fragment_activity_dashboard,c1).commit()*/
        }

    }

class MyView(itemview : View):RecyclerView.ViewHolder(itemview) {

    var image:ImageView = itemview.findViewById(R.id.image)
    var text:TextView = itemview.findViewById(R.id.text)

}
