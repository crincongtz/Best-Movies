package com.crincongtz.bestmovies.movies.presentation.mvp

import android.util.Log
import com.crincongtz.bestmovies.BuildConfig
import com.crincongtz.bestmovies.common.presentation.mvp.LifecycleStopAwareRxPresenter
import com.crincongtz.bestmovies.common.presentation.rx.withProgressIndicator
import com.crincongtz.bestmovies.movies.data.services.MovieApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.rxjava3.schedulers.Schedulers.io
import javax.inject.Inject

class MovieListPresenter @Inject constructor(
    override var view: MovieListContract.View,
    private val movieApi: MovieApi
) : LifecycleStopAwareRxPresenter<MovieListContract.View>(view), MovieListContract.Presenter {

    override fun onStart() {
        movieApi.getAllMovies("popularity.desc", BuildConfig.MOVIE_API_KEY)
            .subscribeOn(io())
            .observeOn(mainThread())
            .withProgressIndicator(view)
            .subscribe({
                view.loadMovieList(it.results)
            }, {
                Log.e("BestMovies", "Error: ${it.message}")
            }).trackDisposable()
    }
}
