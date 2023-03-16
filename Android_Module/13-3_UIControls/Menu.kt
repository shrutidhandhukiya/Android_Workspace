package com.example.uicontrols

import android.Manifest.permission.CALL_PHONE
import android.app.Notification.Action
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        if (checkSelfPermission(CALL_PHONE)!= PackageManager.PERMISSION_GRANTED )
        {

            requestPermissions(arrayOf(CALL_PHONE),101)
        }

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.cn1 ->
            {
                try {

                    var num = "9104046331"
                   var i = Intent(Intent.ACTION_CALL)
                    i.setData(Uri.parse("tel:"+num))
                    startActivity(i)
                }
                catch (e :Exception){

                    Toast.makeText(applicationContext,"please Permission ",Toast.LENGTH_SHORT).show()
                }
            }

            R.id.S1->
            {
                var nm= "9104046331"
                var sms:SmsManager= SmsManager.getDefault()
                sms.sendTextMessage(nm ,null,"Send SMS",null,null)

                Toast.makeText(applicationContext,"SEND SMS",Toast.LENGTH_LONG).show()


            }

            R.id.cn2->
            {

                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are You Sure Want to exit")
                alert.setPositiveButton("Yes") { dialongInterface: DialogInterface, i: Int ->

                    finishAffinity()

                }



            }
        }



        return super.onOptionsItemSelected(item)
    }
}