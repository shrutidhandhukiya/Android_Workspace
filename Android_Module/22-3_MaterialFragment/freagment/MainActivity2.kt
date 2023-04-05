package com.example.freagment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.freagment.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

      //  Activity to Fragment
        binding.btn1.setOnClickListener {

            var f = firstFragment()
            var fm = supportFragmentManager
            var ft = fm.beginTransaction()
            ft.replace(R.id.frmid,f).commit()

        }


    }
}