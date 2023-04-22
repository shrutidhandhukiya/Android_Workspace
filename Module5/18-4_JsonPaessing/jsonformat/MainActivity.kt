package com.example.jsonformat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonformat.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()


        var stringRequest = StringRequest(Request.Method.GET,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productview.php", object :Response.Listener<String>{
            override fun onResponse(response: String?) {

                var jsonArray = JSONArray(response)

                //  until -> jya suthi javu tyare used thay fixed value nthi atle until used.
                for (i in 0 until jsonArray.length() )
                {
                    var jsonObject = jsonArray.getJSONObject(i)

                    var name = jsonObject.getString("product_name")
                    var price = jsonObject.getString("product_price")
                    var des = jsonObject.getString("product_description")
                    var image = jsonObject.getString("product_image")

                    var m = Model()
                    m.name = name
                    m.price =price
                    m.des =des
                    m.image=image

                    list.add(m)

                }

                var adapter = MyAdapter(applicationContext,list)
               binding.list.adapter = adapter

            }
        })

        {
          Toast.makeText(applicationContext,"No InterNet ", Toast.LENGTH_SHORT).show()
        }


    var queue : RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)




    }
}