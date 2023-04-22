package com.example.assingmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assingmentapplication.databinding.ActivityLoginFragmentBinding

class LoginFragment : AppCompatActivity() {

    private lateinit var binding: ActivityLoginFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btn1.setOnClickListener {
              var f =FirstFragment()
             var fm = supportFragmentManager
           var ft = fm.beginTransaction()
         ft.replace(R.id.frmid,f).commit()
        }

        binding.btn2.setOnClickListener {
            var f =SecondFragment()
            var fm = supportFragmentManager
            var ft = fm.beginTransaction()
            ft.replace(R.id.frmid,f).commit()

        }
    }
}