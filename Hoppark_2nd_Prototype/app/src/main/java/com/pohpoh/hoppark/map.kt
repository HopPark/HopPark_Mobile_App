package com.pohpoh.hoppark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.core.app.ActivityCompat
import com.pohpoh.hoppark.databinding.ActivityMainBinding
import com.pohpoh.hoppark.databinding.ActivityMapBinding
import org.osmdroid.api.IMapController

import org.osmdroid.config.Configuration.*
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.BoundingBox
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class map : AppCompatActivity() {
    lateinit var binding: ActivityMapBinding
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 1
    private lateinit var map : MapView
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMapBinding.inflate(layoutInflater)

        setContentView(binding.root)



        getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        setContentView(R.layout.activity_map)

        map = findViewById<MapView>(R.id.map)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMinZoomLevel(11.0)
        map.setMaxZoomLevel(20.0)

        val mapController = map.controller
        mapController.setZoom(12.0)
        val startPoint = GeoPoint(41.0053215,29.0121795)
        mapController.setCenter(startPoint)

        val boundingBox = BoundingBox(41.5053215,30.0121795,40.5053215,28.0121795)
        map.setScrollableAreaLimitDouble(boundingBox)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.nav_home -> {
                    drawerLayout.closeDrawers()
                }
                R.id.park_list -> {
                    intent= Intent(applicationContext,parklist::class.java)
                    startActivity(intent)
                }
                R.id.settings -> {
                    intent= Intent(applicationContext,Ayarlar::class.java)
                    startActivity(intent)
                }
                R.id.account -> {
                    intent= Intent(applicationContext,Profil::class.java)
                    startActivity(intent)
                }
                R.id.balance -> {
                    drawerLayout.closeDrawers()
                }
            }
            true
        }
        navView.bringToFront();
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onResume() {
        super.onResume()
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        map.onResume() //needed for compass, my location overlays, v6.0.0 and up
    }

    override fun onPause() {
        super.onPause()
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        map.onPause()  //needed for compass, my location overlays, v6.0.0 and up
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val permissionsToRequest = ArrayList<String>()
        var i = 0
        while (i < grantResults.size) {
            permissionsToRequest.add(permissions[i])
            i++
        }
        if (permissionsToRequest.size > 0) {
            ActivityCompat.requestPermissions(
                this,
                permissionsToRequest.toTypedArray(),REQUEST_PERMISSIONS_REQUEST_CODE)
        }
    }
}