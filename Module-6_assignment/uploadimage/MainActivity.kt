package com.example.uploadimages

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import net.gotev.uploadservice.MultipartUploadRequest

class MainActivity : AppCompatActivity() {

    lateinit var btn1:Button
    lateinit var edit1:EditText
    lateinit var  btn2:Button
    lateinit var filepath:Uri
    lateinit var  bitmap: Bitmap
    lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          btn1= findViewById(R.id.btn1)
          btn2= findViewById(R.id.btn2)
          edit1 = findViewById(R.id.edt1)
        imageView = findViewById(R.id.img)


        if (checkSelfPermission(READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(READ_EXTERNAL_STORAGE),101)
        }
        else
        {
            Toast.makeText(applicationContext,"Permission already granted", Toast.LENGTH_LONG).show()
        }

        btn1.setOnClickListener {

            var i = Intent()
            i.setType("image/*")
            i.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(i, "Select Picture"), 1)

        }

        btn2.setOnClickListener {

            var name = edit1.text.toString()
            var path = getPath(filepath)
                MultipartUploadRequest(this,"https://shruti76.000webhostapp.com/upload.php")
                    .addFileToUpload(path,"url")
                    .addParameter("name",name)
                    .setMaxRetries(2)
                    . startUpload()
            Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
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
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==1&& resultCode== RESULT_OK && data!= null)
        {
            filepath= data.data!!
            bitmap = MediaStore.Images.Media.getBitmap(contentResolver,filepath)
            imageView.setImageBitmap(bitmap)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }


    }
