package com.example.project.ui.Home.Account

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout
import com.example.project.Activity.DashboardActivity
import com.example.project.Activity.LoginActivity
import com.example.project.R

class AccountFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var layout: ConstraintLayout


     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        sharedPreferences = requireContext().getSharedPreferences("SESSION",Context.MODE_PRIVATE)

         var view =  inflater.inflate(R.layout.fragment_account, container, false)

         layout = view.findViewById(R.id.clLogOut)

         layout.setOnClickListener {

             sharedPreferences.edit().clear().commit()
             activity?.finish()

             startActivity(Intent(context,LoginActivity::class.java))
         }

         return  view
    }

}
