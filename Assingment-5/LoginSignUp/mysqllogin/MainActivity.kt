package com.example.mysqllogin

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mysqllogin.databinding.ActivityMainBinding
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var gender =" "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogIn.setOnClickListener {


            var phone = binding.edtmob.text.toString()
            var pass = binding.edtPassword.text.toString()

            var stringRequest: StringRequest = object :StringRequest(Request.Method.POST,
                "https://shruti76.000webhostapp.com/Login.php",
                { response ->

                    try {
                        if (response.trim().equals("0")) {

                            Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(applicationContext, "Login done", Toast.LENGTH_LONG)
                                .show()

                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                },
                {

                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
                })

            {
                override fun getParams(): MutableMap<String, String>? {
                    var map = HashMap<String,String>()


                    map["mob"]= phone
                    map["pass"]=pass

                    return map
                }
            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)

        }

        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,Register_Activity::class.java))
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            1->
            {
                var i = Intent(applicationContext,UpdateActivity::class.java)
            }
            2->
            {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are You Change ?")
                alert.setPositiveButton("Yes ") { dialogInterface: DialogInterface, i: Int ->

                    var stringRequest:StringRequest = object:StringRequest(Request.Method.POST,
                        "https://shruti76.000webhostapp.com/API/delete.php",Response.Listener {

                            Toast.makeText(applicationContext,"DELETED",Toast.LENGTH_LONG).show()
                            var i = Intent(applicationContext,Register_Activity::class.java)
                            startActivity(i)

                        },{

                            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                        })
                    {
                        override fun getParams(): MutableMap<String, String>? {

                            var map = HashMap<String,String>()
                             // map.put("phone",)
                            // map.put("product_id",m.id)
                            return map
                        }

                    }
                }

            alert.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int -> }

        }
    }
    return super.onOptionsItemSelected(item)
}



}

