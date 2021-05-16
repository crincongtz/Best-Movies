package com.crincongtz.bestmovies.movies.data.services

import com.crincongtz.bestmovies.movies.data.network.model.MoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie")
    fun getAllMovies(
        @Query("sort_by") sortBy: String,
        @Query("api_key") apiKey: String
    ): Single<MoviesResponse>
}
