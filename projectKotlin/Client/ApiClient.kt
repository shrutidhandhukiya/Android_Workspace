package com.example.project.Client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object
    {
        var URL  = "https://shruti76.000webhostapp.com/GiftShopProject/ "
        var retrofit : Retrofit
        ? = null

        fun getretofit(): Retrofit?
        {
            if (retrofit == null)
            {
                retrofit = Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
          return retrofit
        }
    }


}