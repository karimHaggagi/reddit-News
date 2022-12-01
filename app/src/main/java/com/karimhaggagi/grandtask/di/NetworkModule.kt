package com.karimhaggagi.grandtask.di

import com.karimhaggagi.grandtask.data.data_source.remote.AppNetwork.provideApiService
import com.karimhaggagi.grandtask.data.data_source.remote.AppNetwork.provideOkHttpClient
import com.karimhaggagi.grandtask.data.data_source.remote.AppNetwork.provideRetrofit
import com.karimhaggagi.grandtask.presentation.utils.AppConstants.BASE_URL
import org.koin.dsl.module

val networkModule = module {

    single { provideOkHttpClient() }
    single { provideRetrofit(get(), BASE_URL) }
    single { provideApiService(get()) }
}