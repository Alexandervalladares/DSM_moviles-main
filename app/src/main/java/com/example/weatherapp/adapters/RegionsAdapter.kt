package com.example.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R

class RegionsAdapter(
    private val regions: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<RegionsAdapter.RegionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_region, parent, false)
        return RegionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        holder.bind(regions[position])
    }

    override fun getItemCount(): Int = regions.size

    inner class RegionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(region: String) {
            itemView.findViewById<TextView>(R.id.tvRegionName).text = region
            itemView.setOnClickListener { onClick(region) }
        }
    }
}