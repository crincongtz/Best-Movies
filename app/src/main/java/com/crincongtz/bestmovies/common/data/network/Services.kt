package com.crincongtz.bestmovies.common.data.network

import android.content.Context
import com.crincongtz.bestmovies.movies.data.services.MovieApi

object Services {

    fun createMovieService(context: Context): MovieApi {
        return ServiceBuilder(context)
            .build(MovieApi::class.java)
    }
}
