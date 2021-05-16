package com.crincongtz.bestmovies.dagger.components

import android.content.Context
import com.crincongtz.bestmovies.common.data.network.ServiceBuilder
import com.crincongtz.bestmovies.dagger.modules.ServiceBuilderModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ServiceBuilderModule::class
])
interface ServiceBuilderComponent {
    fun inject(serviceBuilder: ServiceBuilder)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): ServiceBuilderComponent
    }

    companion object {
        fun get(
            context: Context
        ): ServiceBuilderComponent {
            return DaggerServiceBuilderComponent.factory()
                .create(context)
        }
    }
}
