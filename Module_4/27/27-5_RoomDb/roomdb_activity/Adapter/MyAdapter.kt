package com.example.roomdb_activity.Adapter

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdb_activity.Activity.AdduserActivity
import com.example.roomdb_activity.DataBase.MyDb
import com.example.roomdb_activity.Entity.User
import com.example.roomdb_activity.Globalvariable.GlobalVariables
import com.example.roomdb_activity.R

class MyAdapter(var context: Context,var list: MutableList<User>) :RecyclerView.Adapter<Myview>()
{
  var db:MyDb? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview {


        context = parent.getContext()
        db = Room.databaseBuilder(parent.getContext(),
            MyDb::class.java,"myDatabase").allowMainThreadQueries().build()

        var v :View = LayoutInflater.from(parent.context).inflate(R.layout.design_layout,parent,false)
        return Myview(v)

        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design_layout,parent,false)
        return Myview(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: Myview, position: Int)
    {
        holder.txt1.setText(list.get(position).name)
        holder.txt2.setText(list.get(position).pass)

        holder.itemView.setOnClickListener {

            var alert = AlertDialog.Builder(context)
            alert.setTitle("Delete ?")
            alert.setPositiveButton("Update") { dialogInterface: DialogInterface, i: Int ->

                GlobalVariables.id = list[position].id
                GlobalVariables.name = list[position].name
                GlobalVariables.email = list[position].pass
                GlobalVariables.updateFlag = "update"

                val intent = Intent(context, AdduserActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context!!.startActivity(intent)

            }


            alert.setNegativeButton("Delete") { dialogInterface: DialogInterface, i: Int ->

                deleteUser(list.get(position).id)
                list.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,list.size)

            }
            alert.show()
        }

    }

    fun  deleteUser(id:Int)
    {
        var user = User()
        user.id = id
        db!!.daoClass().deleteuser(user)
        Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show()
    }

}
class Myview(itemview: View) :RecyclerView.ViewHolder(itemview) {


    var txt1: TextView = itemview.findViewById(R.id.txt1)
    var txt2: TextView = itemview.findViewById(R.id.txt2)

}
