package com.example.jsonobject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonobject.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var  list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        var stringRequest = StringRequest(Request.Method.POST,"https://www.simplifiedcoding.net/demos/view-flipper/heroes.php",
            object :Response.Listener<String>
            {
                override fun onResponse(response: String?) {

                    var jsonObject = JSONObject(response)
                    var jsonArray = jsonObject.getJSONArray("heroes")

                    for ( i in 0 until  jsonArray.length())
                    {
                        var jsonObject2 = jsonArray.getJSONObject(i)


                        var name = jsonObject2.getString("name")
                        var image = jsonObject2.getString("imageurl")

                        var m = Model()
                        m.name = name
                        m.image = image

                        list.add(m)

                    }
                    var adapter = MyAdapter(applicationContext, list as ArrayList<Model>)
                    binding.list1.adapter = adapter
                }


            })
        {
            Toast.makeText(applicationContext,"Not InterNet ", Toast.LENGTH_SHORT).show()
        }

        var queue:RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)
    }
}