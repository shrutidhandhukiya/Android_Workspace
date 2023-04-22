package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var  toolbar : androidx.appcompat.widget.Toolbar
    lateinit var  tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name="Xyz"
        var b = Bundle()
        b.putString("Tops",name)

        //val bundle = Bundle()
        b.putString("message", "StutasFragment")

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.viewPager)
        setupviewpager()

        tabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setupviewpager() {

        var adapter = MyAdapter(supportFragmentManager)
        adapter.data("CHAT",ChatFragment())
        adapter.data("STATUS" , StutasFragment())
        adapter.data("CALL",CallFreagment())
        viewPager.adapter = adapter

      }


}