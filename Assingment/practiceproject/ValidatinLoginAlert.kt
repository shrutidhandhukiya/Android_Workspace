package com.example.practiceproject

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.SEND_SMS
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat


class ValidatinLoginAlert : AppCompatActivity() {

    lateinit var edt1:EditText
    lateinit var edt2: EditText
    lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validatin_login_alert)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)


     /*   if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED)
        {

            requestPermissions(arrayOf(CALL_PHONE),101)
        }
*/
        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED && checkSelfPermission(SEND_SMS)!=PERMISSION_GRANTED)
        {

            ActivityCompat.requestPermissions(this,arrayOf(SEND_SMS),101)
        }

         btn1.setOnClickListener {

             var ed = edt1.text.toString()
             var pass = edt2.text.toString()

             if ( ed.isEmpty() && pass.isEmpty())
             {

                 edt1.setError("")
                 edt2.setError("")
             }

             var i = Intent(applicationContext,PassingData::class.java)
             i.putExtra("NAME",ed)
             i.putExtra("PASSWORD", pass)
             startActivity(i)
         }

    }

    override fun onBackPressed() {

         var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Are you Sure You want to Exit ")
        alertDialog.setPositiveButton("Yes ") { dialogInterface: DialogInterface,d: Int ->

            finishAffinity()
        }

        alertDialog.setNegativeButton("NO ") { dialogInterface: DialogInterface, d: Int ->

            dialogInterface.dismiss()

        }
        alertDialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.context,menu)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId)
        {
            R.id.tvitem ->
            {
                finishAffinity()
            }

            R.id.tvitem1 ->
            {
                try {
                    var num = "9104046331"
                    var i = Intent(Intent.ACTION_CALL)
                    i.setData(Uri.parse("tel :"+num))
                    startActivity(i)
                }
                catch (e:Exception)
                {

                }

            }

            R.id.tvitem2->
            {
                var num="9104046331"
                var sm: SmsManager = SmsManager.getDefault()
                sm.sendTextMessage(num,"hello",null,null,null)
                Toast.makeText(applicationContext,"Sms Sent", Toast.LENGTH_LONG).show()

            }

        }

        return super.onOptionsItemSelected(item)
    }

}