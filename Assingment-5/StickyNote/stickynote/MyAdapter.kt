package com.example.stickynote

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class MyAdapter(var list: MutableList<Model>):RecyclerView.Adapter<MyView>(){

    lateinit var dbHelper: DbHelper
    private var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        context = parent.getContext()
        var inflater = LayoutInflater.from(parent.getContext())
        var view = inflater.inflate(R.layout.raw_desing_layout,parent,false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {

        var context = holder.itemView.context

        var id = position
        val user = list!![id]


        dbHelper = DbHelper(context)

        holder.tvTitle.setText(list.get(position).title)
        holder.tvDec.setText(list.get(position).des)

        holder.imge1.setOnClickListener {

            var alert = AlertDialog.Builder(context)
            alert.setTitle("Select Operation?")

            alert.setPositiveButton("yes") { dialogInterface: DialogInterface, i: Int ->

             dbHelper.deletedata(user.id)

                var i = Intent(context,MainActivity::class.java)
                context.startActivity(i)
            }

            alert.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->

                dialogInterface.cancel()
            }

            alert.show()
        }

        holder.imge2.setOnClickListener {

            var i = Intent(context,UpdateActivity::class.java)

            i.putExtra("id",user.id)
            i.putExtra("title",user.title)
            i.putExtra("description",user.des)

            context.startActivity(i)

        }
    }

    override fun getItemCount(): Int {
      return  list.size
    }
}



class MyView (itemview:View):RecyclerView.ViewHolder(itemview) {

    var tvTitle:TextView = itemview.findViewById(R.id.tvTitle)
    var tvDec:TextView = itemview.findViewById(R.id.tvDec)
    var imge1:ImageView = itemview.findViewById(R.id.imge1)
    var imge2:ImageView = itemview.findViewById(R.id.imge2)


}


