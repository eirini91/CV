package com.eirinitelevantou.cv.network.remote

import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.eirinitelevantou.cv.BuildConfig.BASE_URL
import com.google.gson.GsonBuilder
import javax.inject.Inject
import javax.inject.Singleton

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Singleton
class ApiClient(private val retrofitBuilder: Retrofit.Builder) {

    @Inject
    constructor() : this(Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                            .create()
            ))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()))

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofitBuilder.build().create(serviceClass)
    }

}
