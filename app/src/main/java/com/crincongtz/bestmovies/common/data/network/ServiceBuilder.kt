package com.crincongtz.bestmovies.common.data.network

import android.content.Context
import com.crincongtz.bestmovies.dagger.components.ServiceBuilderComponent
import com.crincongtz.bestmovies.utils.BASE_URL
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class ServiceBuilder(val context: Context) {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Inject
    lateinit var moshi: Moshi

    init {
        injectDependencies()
    }

    private fun injectDependencies() {
        ServiceBuilderComponent.get(context).inject(this)
    }

    fun <S> build(serviceClass: Class<S>): S {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(serviceClass)
    }
}
