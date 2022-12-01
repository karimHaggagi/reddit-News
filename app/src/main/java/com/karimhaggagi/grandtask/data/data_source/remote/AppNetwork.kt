package com.karimhaggagi.grandtask.data.data_source.remote

import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppNetwork {

    fun provideOkHttpClient(
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .protocols(listOf(Protocol.HTTP_1_1))
            .readTimeout(
                60,
                TimeUnit.SECONDS
            )
            .writeTimeout(
                60,
                TimeUnit.SECONDS
            )
            .connectTimeout(
                60,
                TimeUnit.SECONDS
            )
            .build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}