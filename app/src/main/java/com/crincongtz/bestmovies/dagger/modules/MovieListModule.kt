package com.crincongtz.bestmovies.dagger.modules

import android.content.Context
import com.crincongtz.bestmovies.common.dagger.ActivityScope
import com.crincongtz.bestmovies.common.data.network.Services
import com.crincongtz.bestmovies.movies.data.services.MovieApi
import com.crincongtz.bestmovies.movies.presentation.mvp.MovieListContract
import com.crincongtz.bestmovies.movies.presentation.mvp.MovieListPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface MovieListModule {

    @Binds
    @ActivityScope
    fun bindsPresenter(presenter: MovieListPresenter): MovieListContract.Presenter

    companion object {

        @Provides
        @ActivityScope
        fun provideService(context: Context): MovieApi = Services.createMovieService(context)
    }
}
