package com.example.map_activity

import android.Manifest
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.location.LocationManager.NETWORK_PROVIDER
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


import com.example.map_activity.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    lateinit var location:Location
    var lat=0.00
    var lng=0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)

        var locationmanager:LocationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        if(!locationmanager.isProviderEnabled(GPS_PROVIDER))
        {
            Toast.makeText(applicationContext,"GPS is not working",Toast.LENGTH_LONG).show()
        }

        if(!locationmanager.isProviderEnabled(NETWORK_PROVIDER))
        {
            Toast.makeText(applicationContext,"Network is not working",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(applicationContext,"Fetching Location",Toast.LENGTH_LONG).show()
        }

        val locationListener = object :LocationListener
        {
            override fun onLocationChanged(location: Location)
            {
                lat = location.latitude
                lng = location.longitude
            }

        }
        if (locationmanager.isProviderEnabled(NETWORK_PROVIDER))
        {
            // manager.requestLocationUpdates(NETWORK_PROVIDER, 0.0F, 0, locationListener)
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return
            }
            locationmanager.requestLocationUpdates(NETWORK_PROVIDER,0,0.0F,locationListener)

            // locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,);
        }
        location = locationmanager.getLastKnownLocation(NETWORK_PROVIDER)!!
        if(location!=null)
        {
            lat = location.getLatitude();
            lng = location.getLongitude();
            Toast.makeText(applicationContext, ""+location.getLatitude(), Toast.LENGTH_SHORT).show();
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(lat,lng)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in India"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}