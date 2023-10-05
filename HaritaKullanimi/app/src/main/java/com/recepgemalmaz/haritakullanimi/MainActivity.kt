package com.recepgemalmaz.haritakullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.recepgemalmaz.haritakullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback{
    private lateinit var binding: ActivityMainBinding
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.konumaGit.setOnClickListener {

            //41.0053702,28.6825434,10z
            val konum = LatLng(41.0053702,28.6825434)
            mMap.addMarker(MarkerOptions().position(konum).title("İstanbul")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.resim)))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum,10f))
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE



        }
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0
        //39.9032599,32.5979548,11z
        val konum = LatLng(39.9032599,32.5979548)
        mMap.addMarker(MarkerOptions().position(konum).title("Ankara"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum,7f))
    }


}