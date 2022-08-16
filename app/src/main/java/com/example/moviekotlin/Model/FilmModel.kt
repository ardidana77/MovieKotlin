package com.example.moviekotlin.Model

data class FilmModel(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<ResultFilms>
)

data class ResultFilms(
    val characters: List<String>,
    val created: String,
    val director: String,
    val edited: String,
    val episode_id: Int,
    val opening_crawl: String,
    val planets: List<String>,
    val producer: String,
    val release_date: String,
    val species: List<String>,
    val starships: List<String>,
    val title: String,
    val url: String,
    val vehicles: List<String>
)