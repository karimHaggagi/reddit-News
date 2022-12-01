package com.karimhaggagi.grandtask.custom_application

import android.app.Application
import com.bumptech.glide.Glide
import com.karimhaggagi.grandtask.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                    localModule
                )
            )
        }

        Glide.get(this).clearMemory()

    }
}