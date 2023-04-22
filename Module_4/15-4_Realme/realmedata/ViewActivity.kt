package com.example.realmedata

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.realmedata.databinding.ActivityViewBinding
import io.realm.Realm
import io.realm.RealmResults

class ViewActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var binding: ActivityViewBinding
    lateinit var  list: MutableList<Model>
    lateinit var  realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        realm =  Realm.getInstance(Realm.getDefaultConfiguration()!!)

        realm.beginTransaction()

        var result :RealmResults<Model> = realm.where(Model::class.java).findAll()

        for (i in result .indices)
        {
            list.add(result[i]!!)
        }

        var adapter = MyAdapter(applicationContext,list)
        binding.list.adapter = adapter

        realm.commitTransaction()

        binding.list.setOnItemClickListener(this)

    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

         var alert = AlertDialog.Builder(this)
          alert.setTitle("Select Operations ")
         alert.setPositiveButton("Update") { dialogInterface: DialogInterface, i: Int ->

           var alert2 = AlertDialog.Builder(this)
           var layout = LayoutInflater.from(applicationContext)
           var view = layout.inflate(R.layout.update_layout,null)

             alert2.setView(view)

             var edt1: EditText = view.findViewById(R.id.edit1)
             var edt2:EditText= view.findViewById(R.id.edit2)

             edt1.setText(list.get(p2).name)
             edt2.setText(list.get(p2).pass)

   alert2.setPositiveButton("Update") { dialogInterface: DialogInterface, i: Int ->

       var name = edt1.text.toString()
       var pass = edt2.text.toString()

    realm.beginTransaction()

       list.get(p2).name = name
       list.get(p2).pass = pass

       realm.commitTransaction()

       startActivity(Intent(this,ViewActivity::class.java))
     }
             alert2.show()

         }

        alert.setNegativeButton("Delete") { dialogInterface: DialogInterface, i: Int ->

           realm.beginTransaction()


            //delete Code start
            var deleteresult :RealmResults<Model> = realm.where(Model::class.java).findAll()
            deleteresult.deleteFromRealm(p2)

            realm.commitTransaction()
            startActivity(Intent(applicationContext,ViewActivity::class.java))
        }
        alert.show()
        }

    override fun onBackPressed() {

        finishAffinity()
        super.onBackPressed()
    }
}