package com.crincongtz.bestmovies.movies.presentation.navigation

import android.app.Activity
import com.crincongtz.bestmovies.common.navigation.DedicatedNavigator
import com.crincongtz.bestmovies.movies.presentation.mvp.MovieListActivity
import javax.inject.Inject

interface MovieListNavigator : DedicatedNavigator {
    fun launchMovieListScreen()
}

class MovieListNavigatorImpl @Inject constructor(private val activity: Activity) : MovieListNavigator {
    override fun launchMovieListScreen() {
        activity.startActivity(MovieListActivity.createIntent(activity))
    }
}
