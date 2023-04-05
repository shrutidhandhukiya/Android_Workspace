package com.example.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


class ChatFragment : Fragment() {

    lateinit var listView: ListView
    lateinit var list: MutableList<Model>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment

        var view =  inflater.inflate(R.layout.fragment_chat, container, false)


        listView = view.findViewById(R.id.list)
        list = ArrayList()

        list.add(Model(R.drawable.betterfly,"Shruti","30 min"))
        list.add(Model(R.drawable.betterfly,"Shruti","30 min"))
        list.add(Model(R.drawable.betterfly,"Burger","30 min"))
        list.add(Model(R.drawable.betterfly,"Burger","30 min"))

      var adapter = Adapter(context,list)
        listView.adapter = adapter

     return view

    }
}