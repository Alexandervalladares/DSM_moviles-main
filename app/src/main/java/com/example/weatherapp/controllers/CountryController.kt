package com.example.weatherapp.controllers

import com.example.weatherapp.api.RestCountriesService
import com.example.weatherapp.models.Country
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryController {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val api = retrofit.create(RestCountriesService::class.java)

    fun getAllCountries(callback: (List<Country>?) -> Unit) {
        api.getAllCountries().enqueue(object : retrofit2.Callback<List<Country>> {
            override fun onResponse(call: retrofit2.Call<List<Country>>, response: retrofit2.Response<List<Country>>) {
                callback(response.body())
            }
            override fun onFailure(call: retrofit2.Call<List<Country>>, t: Throwable) {
                callback(null)
            }
        })
    }

    fun getCountriesByRegion(region: String, callback: (List<Country>?) -> Unit) {
        api.getCountriesByRegion(region).enqueue(object : retrofit2.Callback<List<Country>> {
            override fun onResponse(call: retrofit2.Call<List<Country>>, response: retrofit2.Response<List<Country>>) {
                callback(response.body())
            }
            override fun onFailure(call: retrofit2.Call<List<Country>>, t: Throwable) {
                callback(null)
            }
        })
    }
}