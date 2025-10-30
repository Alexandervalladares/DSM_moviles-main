package com.example.weatherapp.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.R
import com.example.weatherapp.models.Country
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_country_detail.*
import java.text.NumberFormat
import java.util.*

class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)

        val country = intent.getSerializableExtra("COUNTRY_DATA") as? Country
        if (country == null) {
            Toast.makeText(this, "No se pudo cargar el país.", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        tvOfficialName.text = country.name.official
        tvCommonName.text = country.name.common
        tvRegion.text = country.region
        tvSubregion.text = country.subregion ?: "Sin subregión"
        tvPopulation.text = NumberFormat.getInstance(Locale.getDefault()).format(country.population)
        tvISO2.text = country.cca2
        tvISO3.text = country.cca3
        tvCapital.text = country.capital?.joinToString() ?: "Sin capital"
        tvCurrencies.text = country.currencies?.values?.joinToString { it.name ?: "" } ?: "Sin monedas"
        tvLanguages.text = country.languages?.values?.joinToString() ?: "Sin idiomas"
        tvCoordinates.text = country.latlng?.joinToString(", ") ?: "Sin coordenadas"
        Glide.with(this).load(country.flags.png).into(imgFlag)

        // Aquí puedes llamar a tu función fetchWeatherData(capital) si quieres mostrar el clima.
        // Por ejemplo: fetchWeatherData(country.capital?.firstOrNull() ?: "")
        // Si ya tienes la integración, llama aquí y muestra los datos de clima en la misma pantalla.
    }
}