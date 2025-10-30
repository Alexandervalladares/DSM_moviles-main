package com.example.weatherapp.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.adapters.CountriesAdapter
import com.example.weatherapp.controllers.CountryController
import com.example.weatherapp.models.Country
import kotlinx.android.synthetic.main.activity_countries.*

class CountriesActivity : AppCompatActivity() {

    private val countryController = CountryController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        val region = intent.getStringExtra("REGION_NAME") ?: ""
        rvCountries.layoutManager = LinearLayoutManager(this)
        pbLoadingCountries.visibility = View.VISIBLE

        countryController.getCountriesByRegion(region) { countries ->
            pbLoadingCountries.visibility = View.GONE
            if (countries == null) {
                Toast.makeText(this, "Error al cargar países", Toast.LENGTH_LONG).show()
                return@getCountriesByRegion
            }
            rvCountries.adapter = CountriesAdapter(countries) { country ->
                val intent = Intent(this, CountryDetailActivity::class.java)
                intent.putExtra("COUNTRY_DATA", country)
                startActivity(intent)
            }
        }
    }
}