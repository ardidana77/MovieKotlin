package com.example.moviekotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviekotlin.Model.ResultFilms
import com.example.moviekotlin.databinding.LayoutRvItemBinding

class FilmAdapter : RecyclerView.Adapter<FilmViewHolder>() {

    var films = mutableListOf<ResultFilms>()
    var listener: RecyclerviewFilmClickListener? = null

    fun setFilmList(movies: List<ResultFilms>) {
        this.films= movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val movie = films[position]
        holder.binding.movieTitle.text = movie.title

        holder.binding.cvitemList.setOnClickListener {
            listener?.onFilmsItemClicked(it, films[position])
        }
    }

    override fun getItemCount(): Int {
        return films.size
    }
}

class FilmViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

}