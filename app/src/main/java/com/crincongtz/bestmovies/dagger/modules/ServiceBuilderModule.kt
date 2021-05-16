package com.crincongtz.bestmovies.dagger.modules

import android.content.Context
import android.util.Log
import com.crincongtz.bestmovies.BuildConfig
import com.crincongtz.bestmovies.utils.DEFAULT_TIMEOUT
import com.crincongtz.bestmovies.utils.DateTypeAdapter
import com.crincongtz.bestmovies.utils.OK_HTTP_CACHE_SIZE
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ServiceBuilderModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(httpLoggingInterceptor)
        }
        httpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        httpClient.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        httpClient.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)

        return httpClient
            .cache(cache).build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideCache(context: Context): Cache {
        var cache: Cache? = null
        try {
            val httpCacheDirectory = File(context.cacheDir, "http-responses")
            cache = Cache(httpCacheDirectory, OK_HTTP_CACHE_SIZE)
        } catch (e: Exception) {
            Log.e("NetworkModule", "Could not create Cache!", e)
        }
        return cache!!
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).add(DateTypeAdapter()).build()
}
