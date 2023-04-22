package com.example.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyAdapter(fm : FragmentManager):FragmentPagerAdapter(fm) {

    var listFragment:MutableList<Fragment> = ArrayList()
    var listtitle:MutableList<String> = ArrayList()


    override fun getCount(): Int {
     return  listFragment.size

    }

    override fun getItem(position: Int): Fragment {

        return  listFragment.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return listtitle.get(position)
    }

    fun data (title :String ,fragment: Fragment){
        listtitle.add(title)

        listFragment.add(fragment)

    }
}