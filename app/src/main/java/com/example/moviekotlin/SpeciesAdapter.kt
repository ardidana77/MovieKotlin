package com.example.moviekotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviekotlin.Model.ResultSpecies
import com.example.moviekotlin.databinding.LayoutRvItemBinding

class SpeciesAdapter : RecyclerView.Adapter<SpeciesViewHolder>() {

    var species = mutableListOf<ResultSpecies>()
    var listener: RecyclerviewSpeciesClickListener? = null

    fun setSpeciesList(movies: List<ResultSpecies>) {
        this.species = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return SpeciesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpeciesViewHolder, position: Int) {
        val speciess = species[position]
        holder.binding.movieTitle.text = speciess.name

        holder.binding.cvitemList.setOnClickListener {
            listener?.onSpeciesItemClicked(it, species[position])
        }
    }

    override fun getItemCount(): Int {
        return species.size
    }
}

class SpeciesViewHolder (val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root){

}
