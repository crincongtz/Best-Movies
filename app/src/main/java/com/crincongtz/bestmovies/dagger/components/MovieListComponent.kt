package com.crincongtz.bestmovies.dagger.components

import android.app.Activity
import com.crincongtz.bestmovies.common.dagger.ActivityScope
import com.crincongtz.bestmovies.dagger.modules.ActivityAsContextModule
import com.crincongtz.bestmovies.dagger.modules.MovieListModule
import com.crincongtz.bestmovies.movies.presentation.mvp.MovieListActivity
import com.crincongtz.bestmovies.movies.presentation.mvp.MovieListContract
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [
    ActivityAsContextModule::class,
    MovieListModule::class
])
interface MovieListComponent {
    fun inject(movieListActivity: MovieListActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: Activity,
            @BindsInstance view: MovieListContract.View
        ): MovieListComponent
    }

    companion object {
        fun get(
            view: MovieListContract.View,
            activity: Activity
        ): MovieListComponent {
            return DaggerMovieListComponent.factory()
                .create(activity, view)
        }
    }
}
