package com.example.taskfragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class NameFragment : Fragment() {
  lateinit var  txt :TextView

    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view  = inflater.inflate(R.layout.fragment_name, container, false)

        txt= view. findViewById(R.id.txt)

        txt.setOnClickListener {


          var f = ProfileFragment()
            var fm = fragmentManager
            var ft = fm!!.beginTransaction()
            ft.replace(R.id.fmLayout,f).commit()
        }



        return  view
    }


}