package com.example.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.models.Country
import com.bumptech.glide.Glide

class CountriesAdapter(
    private val countries: List<Country>,
    private val onClick: (Country) -> Unit
) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(country: Country) {
            itemView.findViewById<TextView>(R.id.tvCountryName).text = country.name.common
            itemView.findViewById<TextView>(R.id.tvCapital).text = country.capital?.joinToString() ?: "Sin capital"
            Glide.with(itemView.context)
                .load(country.flags.png)
                .into(itemView.findViewById<ImageView>(R.id.imgFlag))
            itemView.setOnClickListener { onClick(country) }
        }
    }
}