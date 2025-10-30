package com.example.weatherapp.models

data class Country(
    val name: Name,
    val flags: Flags,
    val capital: List<String>?,
    val region: String,
    val subregion: String?,
    val population: Long,
    val cca2: String,
    val cca3: String,
    val currencies: Map<String, Currency>?,
    val languages: Map<String, String>?,
    val latlng: List<Double>?
)

data class Name(
    val common: String,
    val official: String
)

data class Flags(
    val png: String,
    val svg: String
)

data class Currency(
    val name: String?,
    val symbol: String?
)