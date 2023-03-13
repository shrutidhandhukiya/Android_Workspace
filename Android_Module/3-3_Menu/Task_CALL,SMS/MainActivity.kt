package com.example.myapplication

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.SEND_SMS
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Sms
import android.telephony.SmsManager
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    lateinit var tvtebl:ListView
    lateinit var list :MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (checkSelfPermission(CALL_PHONE)!= PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE),101)
        }



        if (checkSelfPermission(SEND_SMS)!= PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(SEND_SMS),101)
        }

        tvtebl = findViewById(R.id.tvtebl)
        list = ArrayList()

        list.add("Number1")
        list.add("Number2")
        list.add("Number3")
        list.add("Number4")

        var adapter= ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        tvtebl.adapter= adapter

      registerForContextMenu(tvtebl)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {


        menuInflater.inflate(R.menu.context_menu,menu)

        super.onCreateContextMenu(menu, v, menuInfo)

    }
    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.itCall->
            {
              try {
                   var num = "9104046331"

                  var i = Intent(Intent.ACTION_CALL)
                  i.setData(Uri.parse("tel:" +num))
                  startActivity(i)
              }
              catch (e:Exception){

                  Toast.makeText(applicationContext,"Allow Permission Granted",Toast.LENGTH_SHORT).show()
              }

            }
            R.id.itSMS->
            {

                var num= "9104046331"
                var sms : SmsManager= SmsManager.getDefault()
                sms.sendTextMessage(num,null,"Hello ",null,null)

                Toast.makeText(applicationContext,"SMS Sent",Toast.LENGTH_LONG).show()

                }
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId){

            R.id.itLgt->
            {

                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you Sure want to exit ")
                alert.setPositiveButton("Yes") { dialongInterface: DialogInterface, i: Int ->

                    finishAffinity()
                }

            alert.setNegativeButton("No") { dialongInterface: DialogInterface, i: Int ->

                dialongInterface.cancel()
            }

             alert.show()
            }


        }


        return super.onOptionsItemSelected(item)
    }


}