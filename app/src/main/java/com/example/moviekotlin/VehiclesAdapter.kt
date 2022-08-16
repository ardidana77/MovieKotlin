package com.example.moviekotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviekotlin.Model.ResultVehicles
import com.example.moviekotlin.databinding.LayoutRvItemBinding

class VehiclesAdapter : RecyclerView.Adapter<VehiclesViewHolder>() {

    var vehicles = mutableListOf<ResultVehicles>()
    var listener: RecyclerviewVehiclesCLickListener? = null

    fun setVehiclesList(movies: List<ResultVehicles>) {
        this.vehicles= movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return VehiclesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VehiclesViewHolder, position: Int) {
        val vehicle = vehicles[position]
        holder.binding.movieTitle.text = vehicle.name

        holder.binding.cvitemList.setOnClickListener {
            listener?.onVehiclesItemClicked(it, vehicles[position])
        }
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

}

class VehiclesViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

}