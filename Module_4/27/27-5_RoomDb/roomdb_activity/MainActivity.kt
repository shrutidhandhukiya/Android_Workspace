package com.example.roomdb_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomdb_activity.Activity.AdduserActivity
import com.example.roomdb_activity.Adapter.MyAdapter
import com.example.roomdb_activity.DataBase.MyDb
import com.example.roomdb_activity.Entity.User
import com.example.roomdb_activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<User>
    var db: MyDb? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //DataBase connect
        db = Room.databaseBuilder(applicationContext,
            MyDb::class.java, "myDatabase").allowMainThreadQueries().build()

        list = ArrayList()

        var l1: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = l1

        list = db!!.daoClass().getUsers()

        var adapter = MyAdapter(applicationContext,list)
        binding.recycler.adapter=adapter


      binding.f1.setOnClickListener {

       startActivity(Intent(applicationContext, AdduserActivity::class.java))
   }

    }
}