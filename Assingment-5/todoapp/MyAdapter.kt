package com.example.todoapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class MyAdapter (var context: Context , var list: MutableList<Model>):RecyclerView.Adapter<MyView>() {

    lateinit var dbHelper: DbHelper


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.row_desing_layout,parent,false)
        return  MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {

        var context = holder.itemView.context

        var id = position
        val user = list[id]

        dbHelper = DbHelper(context)

        holder.title.setText(list.get(position).task)
        holder.priority.setText(list.get(position).des)

        holder.itemView.setOnClickListener {

            var alert = AlertDialog.Builder(context)
            alert.setTitle("Select Operation ?")
            alert.setPositiveButton("update task ") { dialogInterface: DialogInterface, i: Int ->

                var i = Intent(context,UpdateActivity::class.java)

                i.putExtra("id",user.id)
                i.putExtra("title",user.task)
                i.putExtra("description",user.des)

                context.startActivity(i)


            }
            alert.setNegativeButton("remove task") { dialogInterface: DialogInterface, i: Int ->


                dbHelper.deletedata(user.id)

                var i = Intent(context,MainActivity::class.java)
                context.startActivity(i)
            }

            alert.show()
        }




    }

    override fun getItemCount(): Int {

        return  list.size
    }
}

class MyView(itemview :View):RecyclerView.ViewHolder(itemview){


    var title :TextView = itemview.findViewById(R.id.title)
    var priority :TextView = itemview.findViewById(R.id.priority)
}
