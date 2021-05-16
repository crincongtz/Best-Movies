package com.crincongtz.bestmovies.dagger.modules

import android.app.Activity
import android.content.Context
import com.crincongtz.bestmovies.common.dagger.ActivityScope
import dagger.Module
import dagger.Provides

@Module
object ActivityAsContextModule {

    @Provides
    @ActivityScope
    @JvmStatic
    fun provideContext(activity: Activity): Context = activity
}
