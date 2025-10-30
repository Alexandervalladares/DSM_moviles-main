package com.example.weatherapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.adapters.RegionsAdapter
import com.example.weatherapp.controllers.CountryController
import kotlinx.android.synthetic.main.activity_regions.*

class RegionsActivity : AppCompatActivity() {

    private val countryController = CountryController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regions)

        rvRegions.layoutManager = LinearLayoutManager(this)
        pbLoadingRegions.visibility = View.VISIBLE

        countryController.getAllCountries { countries ->
            pbLoadingRegions.visibility = View.GONE
            if (countries == null) {
                Toast.makeText(this, "Error al cargar regiones", Toast.LENGTH_LONG).show()
                return@getAllCountries
            }
            val regions = countries.map { it.region }.distinct().sorted()
            rvRegions.adapter = RegionsAdapter(regions) { region ->
                val intent = Intent(this, CountriesActivity::class.java)
                intent.putExtra("REGION_NAME", region)
                startActivity(intent)
            }
        }
    }
}