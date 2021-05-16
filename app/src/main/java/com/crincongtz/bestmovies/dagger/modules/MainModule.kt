package com.crincongtz.bestmovies.dagger.modules

import com.crincongtz.bestmovies.common.dagger.ActivityScope
import com.crincongtz.bestmovies.main.presentation.mvp.MainContract
import com.crincongtz.bestmovies.main.presentation.mvp.MainPresenter
import com.crincongtz.bestmovies.movies.presentation.navigation.MovieListNavigator
import com.crincongtz.bestmovies.movies.presentation.navigation.MovieListNavigatorImpl
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    @ActivityScope
    fun bindsPresenter(presenter: MainPresenter): MainContract.Presenter

    @Binds
    @ActivityScope
    fun bindsNavigator(navigator: MovieListNavigatorImpl): MovieListNavigator
}
