package com.crincongtz.bestmovies.dagger.components

import android.app.Activity
import com.crincongtz.bestmovies.common.dagger.ActivityScope
import com.crincongtz.bestmovies.dagger.modules.MainModule
import com.crincongtz.bestmovies.main.presentation.mvp.MainActivity
import com.crincongtz.bestmovies.main.presentation.mvp.MainContract
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [
    MainModule::class
])
interface MainComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: Activity,
            @BindsInstance view: MainContract.View
        ): MainComponent
    }

    companion object {
        fun get(
            view: MainContract.View,
            activity: Activity
        ): MainComponent {
            return DaggerMainComponent.factory()
                .create(activity, view)
        }
    }
}
