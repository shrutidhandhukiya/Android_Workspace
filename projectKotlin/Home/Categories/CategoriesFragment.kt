package com.example.project.ui.Home.Categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.Client.ApiClient
import com.example.project.Interface.ApInterface
import com.example.project.Model.CategoryModel
import com.example.project.adapter.CategoryAdapter
import com.example.project.databinding.FragmentCategoriesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    lateinit var mutableList: MutableList<CategoryModel>
    private lateinit var apiInterface: ApInterface


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        val view = binding.root

        /*  var bundle = arguments
       Toast.makeText(activity,""+ bundle!!.getInt("position",101),Toast.LENGTH_SHORT).show()
        val position = bundle!!.getInt("position",1)*/

        mutableList = ArrayList()

        binding.recycler.layoutManager = GridLayoutManager(context,2)

        apiInterface = ApiClient.getretofit()!!.create(ApInterface::class.java)

       var call:Call<List<CategoryModel>> = apiInterface.plantsData()

        call.enqueue(object :Callback<List<CategoryModel>>
        {
            override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>) {
                mutableList = response.body() as MutableList<CategoryModel>

                var adapter = CategoryAdapter(context!!, mutableList)
                binding.recycler.adapter = adapter
            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                Toast.makeText(context,""+t.message, Toast.LENGTH_LONG).show()
            }
        })
        return  view
    }
}


