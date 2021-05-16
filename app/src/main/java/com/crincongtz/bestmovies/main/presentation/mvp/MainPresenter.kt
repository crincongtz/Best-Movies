package com.crincongtz.bestmovies.main.presentation.mvp

import com.crincongtz.bestmovies.movies.presentation.navigation.MovieListNavigator
import javax.inject.Inject

class MainPresenter @Inject constructor(
    override var view: MainContract.View,
    private val movieListNavigator: MovieListNavigator
) : MainContract.Presenter {

    override fun startMovieList() {
        movieListNavigator.launchMovieListScreen()
        view.finish()
    }
}
