package com.example.drawerapplication.ui.Home

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ListView
import com.example.drawerapplication.Model
import com.example.drawerapplication.MyAdapter
import com.example.drawerapplication.R

class HomeFragments : Fragment() {

    lateinit var  list1: GridView
    lateinit var  list: MutableList<Model>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var view =  inflater.inflate(R.layout.fragment_home_fragments, container, false)




       list1 = view.findViewById(R.id.list1)
        list= ArrayList()

        list.add(Model("SUPER GOLD 500ML",R.drawable.goldmilkimg))
        list.add(Model("GOLD 500ML",R.drawable.goldmilkimg))
        list.add(Model("TAAZA 500ML",R.drawable.goldmilkimg))
        list.add(Model("CHAI SHAKTI-1LTR",R.drawable.goldmilkimg))
        list.add(Model("SUPER GOLD 500ML",R.drawable.goldmilkimg))
        list.add(Model("SUPER GOLD 500ML",R.drawable.goldmilkimg))


        var adapter = MyAdapter(requireActivity(),list)
        list1.adapter=adapter

        return  view

    }

}