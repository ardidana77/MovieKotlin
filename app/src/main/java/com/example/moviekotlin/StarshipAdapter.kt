package com.example.moviekotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviekotlin.Model.ResultStarship
import com.example.moviekotlin.databinding.LayoutRvItemBinding

class StarshipAdapter : RecyclerView.Adapter<StarshipViewHolder>() {

    var starship = mutableListOf<ResultStarship>()
    var listener: RecyclerviewStarshipCLickListener? = null

    fun setStarshipList(movies: List<ResultStarship>) {
        this.starship= movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return StarshipViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StarshipViewHolder, position: Int) {
        val starships = starship[position]
        holder.binding.movieTitle.text = starships.name

        holder.binding.cvitemList.setOnClickListener {
            listener?.onStarshipsItemClicked(it, starship[position])
        }
    }

    override fun getItemCount(): Int {
        return starship.size
    }
}

class StarshipViewHolder (val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root){

}
