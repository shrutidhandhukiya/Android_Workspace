package com.example.project.Activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project.Client.ApiClient
import com.example.project.Interface.ApInterface
import com.example.project.databinding.ActivityFullScreenImageBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FullScreenImageActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFullScreenImageBinding
    private lateinit var apiInterface: ApInterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenImageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiInterface = ApiClient.getretofit()!!.create(ApInterface::class.java)
        var i = intent
        var image = i.getStringExtra("imageurl")
        var price = i.getStringExtra("price")
        sharedPreferences = getSharedPreferences("USER_SESSION", MODE_PRIVATE)

        var phone = sharedPreferences.getString("PHONE","")
       // Picasso.get().load(image).into(binding.photoView)

        //wishlist
        binding.btnwishlist.setOnClickListener {
          /*  val call = apiInterface.artwishlist(image,price,phone)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Added to wishlist", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                }
            })*/


        }

        //cart
        binding.btn2.setOnClickListener {
           /* val call = apiInterface.artcart(image,price,phone)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Added to Cart", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                }
            })*/


        }

    }
}