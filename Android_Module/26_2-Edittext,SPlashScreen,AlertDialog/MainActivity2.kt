package com.example.demo

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }


    override fun onBackPressed() {

        var alert = AlertDialog.Builder(this)
        alert.setTitle("Are you sure you want to exit?")
        alert.setPositiveButton("YES") { dialogInterface: DialogInterface, s: Int ->

            finishAffinity()

        }
        alert.setNegativeButton("NO") { dialogInterface: DialogInterface, s: Int ->

            dialogInterface.cancel()

        }

        alert.show()
    }
}