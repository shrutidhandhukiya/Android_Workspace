package com.example.jsonfromattask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonfromattask.databinding.ActivityMainBinding
import org.json.JSONArray


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var  list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        // manager
        var manager:RecyclerView.LayoutManager =LinearLayoutManager(this)
        binding.recycler.layoutManager = manager

        // ApI
         var stringRequest = StringRequest(Request.Method.GET,"https://simplifiedcoding.net/demos/marvel/",
             object : Response.Listener<String>
             {
                 override fun onResponse(response: String?) {


                     var jsonArray = JSONArray(response)

                     for (i in 0 until jsonArray.length())
                     {
                         var jsonObject = jsonArray.getJSONObject(i)

                         var name = jsonObject.getString("name")
                         var relname = jsonObject.getString("realname")
                         var team = jsonObject.getString("team")
                         var firstAppreance = jsonObject.getString("firstappearance")
                         var cretedby= jsonObject.getString("createdby")
                         var publish = jsonObject.getString("publisher")
                         var image = jsonObject.getString("imageurl")


                         var m = Model()
                         m.name = name
                         m.relName= relname
                         m.team = team
                         m.firstApperiance = firstAppreance
                         m.createBy = cretedby
                         m.publish = publish
                         m.image =image

                         list.add(m)


                     }

                     var adapter = MyAdapter(applicationContext,list)
                     binding.recycler.adapter = adapter
                 }


             })

         {
             Toast.makeText(applicationContext,"No Internet ", Toast.LENGTH_SHORT).show()
         }

        var queue:RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)

    }
}