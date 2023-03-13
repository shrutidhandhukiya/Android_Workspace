package com.example.menus

import android.Manifest.permission.CALL_PHONE
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import com.example.menus.R.menu

class ListActivity : AppCompatActivity() {

     lateinit var  tvlist:ListView
     lateinit var  list:MutableList<String>

     @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         if (checkSelfPermission(CALL_PHONE)!= PERMISSION_GRANTED)
         {
             requestPermissions(arrayOf(CALL_PHONE),111)
         }


        setContentView(R.layout.activity_list)

        tvlist = findViewById(R.id.tvlist)

        list = ArrayList()

        list.add("Number1")
        list.add("Number2")
        list.add("Number3")

        val adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        tvlist.adapter = adapter

        registerForContextMenu(tvlist)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
     {

         menuInflater.inflate(R.menu.context_menu,menu)

         super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var a1 : AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo


        when(item.itemId)
        {
            R.id.cnt->
            {

            }
            R.id.cnt1->
            {

            }
        }

        return super.onContextItemSelected(item)
    }
}
