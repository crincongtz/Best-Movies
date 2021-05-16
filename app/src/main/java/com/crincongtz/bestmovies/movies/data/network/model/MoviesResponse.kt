package com.crincongtz.bestmovies.movies.data.network.model

data class MoviesResponse (
    var page: Int,
    var total_results: Int,
    var total_pages: Int,
    var results: List<Movie>
)
