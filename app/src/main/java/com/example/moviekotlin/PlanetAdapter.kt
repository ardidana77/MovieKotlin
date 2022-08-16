package com.example.moviekotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviekotlin.Model.ResultPeople
import com.example.moviekotlin.Model.ResultPlanet
import com.example.moviekotlin.databinding.LayoutRvItemBinding

class PlanetAdapter : RecyclerView.Adapter<PlanetViewHolder>()  {
    var planets = mutableListOf<ResultPlanet>()
    var listener: RecyclerviewPlanetCLickListener? = null

    fun setPlanetList(movies: List<ResultPlanet>) {
        this.planets = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return PlanetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        val movie = planets[position]
        holder.binding.movieTitle.text = movie.name

        holder.binding.cvitemList.setOnClickListener {
            listener?.onPlanetItemClicked(it, planets[position])
        }
    }

    override fun getItemCount(): Int {
        return planets.size
    }
}

class PlanetViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

}