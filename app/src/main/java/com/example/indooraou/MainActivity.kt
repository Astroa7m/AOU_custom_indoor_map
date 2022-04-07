package com.example.indooraou

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.location.LocationManagerCompat
import androidx.core.view.isVisible
import com.example.indooraou.Constants.MAIN_BUILDING_FILL_COLOR
import com.example.indooraou.Constants.MAIN_BUILDING_INNER_FILL_COLOR
import com.example.indooraou.Constants.MAIN_BUILDING_OUTER_FILL_COLOR
import com.example.indooraou.Constants.MAPVIEW_BUNDLE_KEY
import com.example.indooraou.Constants.aouBuildingInnerParkingPoints
import com.example.indooraou.Constants.aouBuildingOuterParkingPoints
import com.example.indooraou.Constants.aouBuildingPoints
import com.example.indooraou.Constants.aouLatLng
import com.example.indooraou.Constants.firstFloor
import com.example.indooraou.Constants.firstFloorPoints
import com.example.indooraou.Constants.firstPolygons
import com.example.indooraou.Constants.groundFloor
import com.example.indooraou.Constants.groundFloorPoints
import com.example.indooraou.Constants.groundPolygons
import com.example.indooraou.Constants.secondFloor
import com.example.indooraou.Constants.secondFloorPoints
import com.example.indooraou.Constants.secondPolygons
import com.example.indooraou.Constants.thirdFloor
import com.example.indooraou.Constants.thirdFloorPoints
import com.example.indooraou.Constants.thirdPolygons
import com.example.indooraou.databinding.ActivityMainBinding
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import com.google.maps.android.clustering.ClusterManager
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMainBinding
    private lateinit var permissionsLauncher: ActivityResultLauncher<Array<String>>
    private var clusterManager: ClusterManager<Spot>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val mapViewBundle = savedInstanceState?.getBundle(MAPVIEW_BUNDLE_KEY)
        binding.mapView.onCreate(mapViewBundle)
        initAll()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY) ?: Bundle().also {
            outState.putBundle(MAPVIEW_BUNDLE_KEY, it)
        }
        binding.mapView.onSaveInstanceState(mapViewBundle)
    }

    @SuppressLint("MissingPermission")
    private fun initAll() {
        // permission callback
        permissionsLauncher =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
                // we don't need to do anything with permission here it is only needed to enable current location
                if (permissions.values.first().not() && permissions.values.last().not()) {
                    Toast.makeText(this, "Permission is not granted", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }

        // views
        binding.mapView.getMapAsync {
            mMap = it
            mMap.setLatLngBoundsForCameraTarget(
                LatLngBounds(
                    LatLng(23.590787514523488, 58.456583954393864),
                    LatLng(23.591346104969617, 58.457354418933384)
                )
            )
            mMap.setMinZoomPreference(19.5f)
            mMap.isMyLocationEnabled = true
            mMap.uiSettings.isMapToolbarEnabled = false
            mMap.uiSettings.isMyLocationButtonEnabled = false
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(aouLatLng, 19.5f))
            mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style_json))
            binding.buttonG.isVisible = true
            binding.button1.isVisible = true
            binding.button2.isVisible = true
            binding.button3.isVisible = true
            binding.tvGround.isVisible = true
            checkManagerInitAndPlaceSelf()
            //adding ground floor as default view for first startup
            clusterManager?.let { manager ->
                manager.addItems(groundFloor)
                manager.cluster()
            }
            //drawing building polygon
            drawBuildingPolygon()
            //drawing ground floor spots polygons for first start up
            drawGroundPolygons()
        }

        binding.buttonG.setOnClickListener {
            checkManagerInitAndPlaceSelf()
            binding.tvGround.isVisible = true
            binding.tvFirst.isVisible = false
            binding.tvSecond.isVisible = false
            binding.tvThird.isVisible = false
            clusterManager?.let {
                it.addItems(groundFloor)
                it.cluster()
            }
            drawGroundPolygons()
            firstPolygons.forEach { it.remove() }
            secondPolygons.forEach { it.remove() }
            thirdPolygons.forEach { it.remove() }
        }

        binding.button1.setOnClickListener {
            checkManagerInitAndPlaceSelf()
            binding.tvGround.isVisible = false
            binding.tvFirst.isVisible = true
            binding.tvSecond.isVisible = false
            binding.tvThird.isVisible = false
            clusterManager?.let {
                it.addItems(firstFloor)
                it.cluster()
            }
            drawFirstPolygons()
            groundPolygons.forEach { it.remove() }
            secondPolygons.forEach { it.remove() }
            thirdPolygons.forEach { it.remove() }
        }

        binding.button2.setOnClickListener {
            checkManagerInitAndPlaceSelf()
            binding.tvGround.isVisible = false
            binding.tvFirst.isVisible = false
            binding.tvSecond.isVisible = true
            binding.tvThird.isVisible = false
            clusterManager?.let {
                it.addItems(secondFloor)
                it.cluster()
            }
            drawSecondPolygons()
            groundPolygons.forEach { it.remove() }
            firstPolygons.forEach { it.remove() }
            thirdPolygons.forEach { it.remove() }

        }

        binding.button3.setOnClickListener {
            checkManagerInitAndPlaceSelf()
            binding.tvGround.isVisible = false
            binding.tvFirst.isVisible = false
            binding.tvSecond.isVisible = false
            binding.tvThird.isVisible = true
            clusterManager?.let {
                it.addItems(thirdFloor)
                it.cluster()
            }
            drawThirdPolygons()
            groundPolygons.forEach { it.remove() }
            firstPolygons.forEach { it.remove() }
            secondPolygons.forEach { it.remove() }
        }

    }

    private fun drawBuildingPolygon() {
        //building
        val aouPolygon = PolygonOptions()
        aouBuildingPoints.forEach { point ->
            aouPolygon.add(point)
        }
        aouPolygon.fillColor(Color.parseColor(MAIN_BUILDING_FILL_COLOR))
        mMap.addPolygon(aouPolygon)
        //inner
        val aouInnerParkingPolygon = PolygonOptions()
        aouInnerParkingPolygon.fillColor(Color.parseColor(MAIN_BUILDING_INNER_FILL_COLOR))
        aouBuildingInnerParkingPoints.forEach { points ->
            aouInnerParkingPolygon.add(points)
        }
        mMap.addPolygon(aouInnerParkingPolygon)
        //outer
        val aouOuterParkingPolygon = PolygonOptions()
        aouOuterParkingPolygon.fillColor(Color.parseColor(MAIN_BUILDING_OUTER_FILL_COLOR))
        aouBuildingOuterParkingPoints.forEach { points ->
            aouOuterParkingPolygon.add(points)
        }
        mMap.addPolygon(aouOuterParkingPolygon)
    }

    private fun drawGroundPolygons() {
        groundFloorPoints.forEach { listOfPoints ->
            val polygon = PolygonOptions().fillColor(
                (Color.argb(
                    50,
                    Random.nextInt(256),
                    Random.nextInt(256),
                    Random.nextInt(256)
                ))
            ).strokeWidth(0f)
            listOfPoints.forEach { groundPoint ->
                polygon.add(groundPoint)
            }
            groundPolygons.add(mMap.addPolygon(polygon))
        }
    }

    private fun drawFirstPolygons() {
        firstFloorPoints.forEach { listOfPoints ->
            val polygon = PolygonOptions().fillColor(
                (Color.argb(
                    50,
                    Random.nextInt(256),
                    Random.nextInt(256),
                    Random.nextInt(256)
                ))
            ).strokeWidth(0f)
            listOfPoints.forEach { firstPoint ->
                polygon.add(firstPoint)
            }
            firstPolygons.add(mMap.addPolygon(polygon))
        }
    }

    private fun drawSecondPolygons() {
        secondFloorPoints.forEach { listOfPoints ->
            val polygon = PolygonOptions().fillColor(
                (Color.argb(
                    50,
                    Random.nextInt(256),
                    Random.nextInt(256),
                    Random.nextInt(256)
                ))
            ).strokeWidth(0f)
            listOfPoints.forEach { secondPoint ->
                polygon.add(secondPoint)
            }
            secondPolygons.add(mMap.addPolygon(polygon))
        }
    }

    private fun drawThirdPolygons() {
        thirdFloorPoints.forEach { listOfPoints ->
            val polygon = PolygonOptions().fillColor(
                (Color.argb(
                    50,
                    Random.nextInt(256),
                    Random.nextInt(256),
                    Random.nextInt(256)
                ))
            ).strokeWidth(0f)
            listOfPoints.forEach { thirdPoint ->
                polygon.add(thirdPoint)
            }
            thirdPolygons.add(mMap.addPolygon(polygon))
        }
    }

    private fun checkManagerInitAndPlaceSelf() {
        if (clusterManager == null) {
            clusterManager = ClusterManager<Spot>(this, mMap).apply {
                renderer = SpotClusterManagerRenderer(this@MainActivity, mMap, this)
            }
            mMap.setOnCameraIdleListener(clusterManager)
        }
        clearClusters()
    }

    private fun clearClusters() {
        clusterManager?.let {
            it.removeItems(groundFloor)
            it.removeItems(firstFloor)
            it.removeItems(secondFloor)
            it.removeItems(thirdFloor)
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestPermissionsForLocation() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            permissionsLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            )
            return
        }
    }

    private fun isGoogleServiceAvailable(): Boolean {
        val googleApiAvailability = GoogleApiAvailability.getInstance()
        val availability = googleApiAvailability.isGooglePlayServicesAvailable(this)
        if (availability != ConnectionResult.SUCCESS) {
            return if (googleApiAvailability.isUserResolvableError(availability)) {
                googleApiAvailability.getErrorDialog(this, availability, 0)?.show()
                false
            } else
                false
        }
        return true
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return LocationManagerCompat.isLocationEnabled(locationManager)
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
        if (isGoogleServiceAvailable())
            requestPermissionsForLocation()

        if (!isLocationEnabled()) {
            AlertDialog.Builder(this)
                .setTitle("Location service is turned off")
                .setMessage("You must enable location service to use the map")
                .setPositiveButton("Go Settings") { _, _ ->
                    Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS).also { startActivity(it) }
                }
                .setNegativeButton("Take me out") { _, _ ->
                    finish()
                }.create()
                .show()
        }
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onPause() {
        binding.mapView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        binding.mapView.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

}