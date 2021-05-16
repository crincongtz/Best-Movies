package com.crincongtz.bestmovies.movies.presentation.mvp

import androidx.lifecycle.LifecycleOwner
import com.crincongtz.bestmovies.common.presentation.mvp.MvpContract
import com.crincongtz.bestmovies.common.presentation.mvp.WithProgressIndicator
import com.crincongtz.bestmovies.movies.data.network.model.Movie

interface MovieListContract {
    interface View : MvpContract.View, WithProgressIndicator, LifecycleOwner {
        fun loadMovieList(movies: List<Movie>)
    }

    interface Presenter : MvpContract.Presenter<View> {
        fun onStart()
    }
}
