package com.example.moviekotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviekotlin.Model.ResultPeople
import com.example.moviekotlin.databinding.LayoutRvItemBinding

class PeopleAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var movies = mutableListOf<ResultPeople>()
    var listener: RecyclerviewPeopleClickListener? = null

    fun setMovieList(movies: List<ResultPeople>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.movieTitle.text = movie.name

        holder.binding.cvitemList.setOnClickListener {
            listener?.onPeopleItemClicked(it, movies[position])
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MainViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

}