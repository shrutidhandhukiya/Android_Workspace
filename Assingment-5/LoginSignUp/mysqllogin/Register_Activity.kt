package com.example.mysqllogin

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mysqllogin.databinding.ActivityRegisterBinding

class Register_Activity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var binding: ActivityRegisterBinding
    var gender = ""
    lateinit var  bitmap: Bitmap
    lateinit var  filePath: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.image.setOnClickListener {
            showFileChooser()

        }

    binding.rbFemale.setOnCheckedChangeListener(this)
        binding.rbMale.setOnCheckedChangeListener(this)


        binding.btnsignup.setOnClickListener {

            var fname = binding.edtFirstName.text.toString()
            var lname = binding.edtLastName.text.toString()
            var email = binding.edtEmail.text.toString()
            var phone = binding.edtPhone.text.toString()
            var pass = binding.edtPassword.text.toString()

            var stringRequest: StringRequest = object : StringRequest(Request.Method.POST,
                "https://shruti76.000webhostapp.com/register.php",Response.Listener {

                    Toast.makeText(applicationContext, "Registration Done", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext, MainActivity::class.java))


                },
                Response.ErrorListener {

                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()


                }) {
                override fun getParams(): MutableMap<String, String>? {

                    var map = HashMap<String, String>()

                    map["firstname"] = fname
                    map["lastname"] = lname
                    map["gender"] = gender
                    map["email"] = email
                    map["phone"] = phone
                    map["password"] = pass

                    return map
                }

            }

            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)
        }

        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }

    @SuppressLint("Range")
    fun getPath(uri: Uri?): String
    {
        var cursor = contentResolver.query(uri!!, null, null, null, null)
        cursor!!.moveToFirst()
        var document_id = cursor.getString(0)
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1)
        cursor.close()
        cursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null, MediaStore.Images.Media._ID + " = ? ", arrayOf(document_id), null)
        cursor!!.moveToFirst()
        val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()
        return path
    }

    private fun showFileChooser() {

        var i = Intent()
        i.setType("image/*")
        i.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(i, "Select Picture"), 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==1&& resultCode== RESULT_OK && data!= null) {
            filePath = data.data!!
            bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
            binding.image.setImageBitmap(bitmap)
        }

        super.onActivityResult(requestCode, resultCode, data)


    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {

        if(binding.rbMale.isChecked)
        {
            gender="Male"
        }

        if(binding.rbFemale.isChecked)
        {
            gender="Female"
        }
    }



}



