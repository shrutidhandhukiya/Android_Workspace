package com.example.project.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project.Client.ApiClient
import com.example.project.Interface.ApInterface
import com.example.project.Model.CategoryProduct
import com.example.project.adapter.CategoryProductAdapter
import com.example.project.databinding.ActivityCategoryProductBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryProductBinding
    lateinit var apiinterface: ApInterface
    lateinit var  list: MutableList<CategoryProduct>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryProductBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        list = ArrayList()

        apiinterface = ApiClient.getretofit()!!.create(ApInterface::class.java)

        binding.rvProductRecycler.layoutManager = GridLayoutManager(this,3)

        var call:Call<List<CategoryProduct>> = apiinterface.productData(image)

        call.enqueue(object : Callback<List<CategoryProduct>>{
            override fun onResponse(
                call: Call<List<CategoryProduct>>,
                response: Response<List<CategoryProduct>>
            ) {
               list = response.body() as MutableList<CategoryProduct>

                var adapter = CategoryProductAdapter(applicationContext,list)
                binding.rvProductRecycler.adapter = adapter
            }
            override fun onFailure(call: Call<List<CategoryProduct>>, t: Throwable) {
                Toast.makeText(applicationContext,""+t.message, Toast.LENGTH_LONG).show()
            }

        })
    }


}