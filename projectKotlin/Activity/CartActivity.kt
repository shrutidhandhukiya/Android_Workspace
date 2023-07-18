package com.example.test

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.adapters.CartAdapter
import com.example.test.databinding.ActivityCartBinding
import com.example.test.databinding.ActivityCategoryBinding
import com.example.test.databinding.ActivityWishListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CartActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityCartBinding
    lateinit var mutableList: MutableList<WishListModel>
    private lateinit var apiInterface: ApiInterface
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mutableList = ArrayList()
        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        binding.recycler.layoutManager = LinearLayoutManager(this)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        var mob =sharedPreferences.getString("mob","")

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        val call: Call<List<WishListModel>> = apiInterface.cartviewdata(mob)
        call.enqueue(object : Callback<List<WishListModel>> {

            override fun onResponse(
                call: Call<List<WishListModel>>,
                response: Response<List<WishListModel>>
            )
            {
                mutableList = response.body() as MutableList<WishListModel>

                val myAdapter = CartAdapter(applicationContext, mutableList)
                binding.recycler.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<WishListModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }
        })

    }
}