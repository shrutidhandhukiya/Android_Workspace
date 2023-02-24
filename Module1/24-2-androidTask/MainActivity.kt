package com.example.taskapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import java.net.URL

class MainActivity : AppCompatActivity() {

     lateinit var  i1 : ImageView
     lateinit var  img2: ImageView
     lateinit var  img3 :ImageView
     lateinit var  img4:ImageView
     lateinit var  img5:ImageView

    lateinit var button1 : Button
    lateinit var button2: Button
    lateinit var button3 : Button
    lateinit var button4 : Button
    lateinit var button5: Button


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         i1= findViewById(R.id.image)
        img2= findViewById(R.id.imageView)
        img3 =findViewById(R.id.imageView2)
        img4 =findViewById(R.id.imageView3)
        img5 = findViewById(R.id.imageView4)

        button1= findViewById(R.id.button1)
        button2= findViewById(R.id.button2)
        button3= findViewById(R.id.button3)
        button4= findViewById(R.id.button4)
        button5= findViewById(R.id.button5)

        supportActionBar?.hide()


        i1.setOnClickListener {

            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
        }

        img2.setOnClickListener {

            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
        }

        img3.setOnClickListener {

            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
        }

        img4.setOnClickListener {

            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
        }

        img5.setOnClickListener {

            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)

        }
        button1.setOnClickListener {

            var url ="https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=58075"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)

        }


      button2.setOnClickListener {

          var url ="https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=58075"
          var i = Intent(Intent.ACTION_VIEW)
          i.setData(Uri.parse(url))
          startActivity(i)
      }

        button3.setOnClickListener {

            var url ="https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=58075"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)

        }

        button4.setOnClickListener {

            var url ="https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=58075"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)


        }

        button5.setOnClickListener {

            var url ="https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=58075"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

    }
}