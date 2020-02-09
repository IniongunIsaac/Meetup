package com.iniongungroups.mobile.android.meetup.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.iniongungroups.mobile.android.meetup.network.BuildConfig
import com.iniongungroups.mobile.android.meetup.network.NetworkConstants
import com.iniongungroups.mobile.android.meetup.network.services.AuthService
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Isaac Iniongun on 2020-02-08.
 * For Meetup project.
 */

@Module
class NetworkModule {

    @Provides
    internal fun provideFile(context: Context): File = File (
        context.cacheDir, NetworkConstants.OKHTTP_CACHE
    )

    @Provides
    internal fun provideCache(file: File): Cache = Cache (
        file, NetworkConstants.OKHTTP_CACHE_SIZE.toLong()
    )

    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor (
        HttpLoggingInterceptor.Logger { log ->
            Timber.e(log)
        }
    ).apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    }

    @Provides
    internal fun provideOkhttpClient(
        cache: Cache,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(httpLoggingInterceptor)
            cache(cache)
            followRedirects(true)
            followSslRedirects(true)
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }.build()
    }

    @Provides
    internal fun provideRxJavaAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    @Provides
    internal fun provideGsonAdapterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    internal fun provideGson(): Gson = GsonBuilder().serializeNulls().create()

    @Provides
    internal fun provideRetrofit(
        okHttpClient: OkHttpClient,
        callAdapterFactory: RxJava2CallAdapterFactory,
        converterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder().apply {
        client(okHttpClient)
        addCallAdapterFactory(callAdapterFactory)
        addConverterFactory(converterFactory)
        baseUrl(BuildConfig.BASE_URL)
    }.build()

    @Provides
    internal fun provideMeetupAuthService(
        retrofit: Retrofit
    ): AuthService = retrofit.create(AuthService::class.java)

}