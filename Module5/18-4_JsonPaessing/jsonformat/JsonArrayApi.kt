package com.example.jsonformat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonformat.databinding.ActivityJsonArrayApiBinding
import org.json.JSONArray
import org.json.JSONObject

class JsonArrayApi : AppCompatActivity() {

    private lateinit var binding: ActivityJsonArrayApiBinding
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJsonArrayApiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        var stringRequest= StringRequest(Request.Method.GET,"https://shruti76.000webhostapp.com/API2/view.php",
            object :Response.Listener<String>{


                override fun onResponse(response: String?) {


                    var jsonArray = JSONArray(response)

                    for (i in 0 until  jsonArray.length())
                    {
                        var jsonObject = jsonArray.getJSONObject(i)

                        var name = jsonObject.getString("p_name")
                        var price = jsonObject.getString("p_price")
                        var des = jsonObject.getString("Good")
                        var image = jsonObject.getString("p_image")

                        var m = Model()
                        m.name = name
                        m.price = price
                        m.des = des
                        m.image = image

             list.add(m)

                    }
                    var adapter = MyAdapter(applicationContext,list)
                    binding.list.adapter = adapter
                }


            })
        {
            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_SHORT).show()
        }

        var queue : RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)

    }
}