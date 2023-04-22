package com.example.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class StutasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=  inflater.inflate(R.layout.fragment_stutas, container, false)

        val fragobj = StutasFragment()
       // fragobj.setArguments()

        return view
    }


}