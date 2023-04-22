package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var  sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("Login ", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("Login",false) && !sharedPreferences.getString("NAME","")!!.isEmpty())
        {
            startActivity(Intent(this,MainActivity2::class.java))

         finish()
        }

        binding.btn.setOnClickListener {
            var name = binding.edt1.text.toString()
            var pass = binding.edt2.text.toString()

            if (name.equals("shruti") && pass.equals("12345"))
            {
                var i = Intent(applicationContext,MainActivity2::class.java)


                var editor :SharedPreferences.Editor = sharedPreferences.edit()

                editor.putBoolean("Login",true)
                editor.putString("NAME",name)
                editor.putString("PASS",pass)
                editor.commit()

                startActivity(i)

            }
            finish()
        }
    }
}