package com.example.playsong

import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.playsong.databinding.ActivityWifiBinding


class WifiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWifiBinding

    override fun onCreate(savedInstanceState: Bundle?)
     {
        super.onCreate(savedInstanceState)
        binding = ActivityWifiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

            //declare of wifiManager
         val wifi = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager


         //on button Click event
         binding.wifiSwitch.setOnClickListener {

             wifi.isWifiEnabled = !wifi.isWifiEnabled

             if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                 if (!wifi.isWifiEnabled()) {
                     wifi.setWifiEnabled(true)

                     binding.tvStuts.text = "Wifi ON"
                     Toast.makeText(applicationContext,"WIFI ON ",Toast.LENGTH_SHORT).show()
                 }
                 else
                 {
                     wifi.setWifiEnabled(false)

                     binding.tvStuts.text = "Wifi is OFF"
                     Toast.makeText(applicationContext,"WIFI OFF ",Toast.LENGTH_SHORT).show()
                 }
             }
             else
             {
                 val panelIntent = Intent(Settings.Panel.ACTION_WIFI)
                 startActivityForResult(panelIntent, 1)
             }
         }
    }
}