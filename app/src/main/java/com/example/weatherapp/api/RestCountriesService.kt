package com.example.weatherapp.api

import com.example.weatherapp.models.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestCountriesService {
    @GET("v3.1/all")
    fun getAllCountries(): Call<List<Country>>

    @GET("v3.1/region/{region}")
    fun getCountriesByRegion(@Path("region") region: String): Call<List<Country>>
}